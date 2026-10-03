const http = require('http');
const fs = require('fs');
const path = require('path');

const PORT = 3000; // Nginx proxies public port 8080 to internal port 3000
const WEB_DIR = path.join(__dirname, 'web');

const MIME_TYPES = {
    '.html': 'text/html; charset=UTF-8',
    '.css': 'text/css; charset=UTF-8',
    '.js': 'application/javascript; charset=UTF-8',
    '.json': 'application/json; charset=UTF-8',
    '.png': 'image/png',
    '.jpg': 'image/jpeg',
    '.jpeg': 'image/jpeg',
    '.svg': 'image/svg+xml',
    '.webp': 'image/webp',
    '.ico': 'image/x-icon'
};

const server = http.createServer((req, res) => {
    const parsedUrl = new URL(req.url, `http://${req.headers.host || 'localhost'}`);
    let pathname = decodeURIComponent(parsedUrl.pathname);

    // Health check endpoint
    if (pathname === '/health' || pathname === '/healthz') {
        res.writeHead(200, { 'Content-Type': 'application/json' });
        res.end(JSON.stringify({ status: 'healthy', studio: 'The Colours Tattoo Studio' }));
        return;
    }

    // Default to index.html for root or client navigation routes
    if (pathname === '/' || !path.extname(pathname)) {
        pathname = '/index.html';
    }

    // Normalize safe file path inside WEB_DIR
    const safePath = path.normalize(pathname).replace(/^(\.\.[\/\\])+/, '');
    const filePath = path.join(WEB_DIR, safePath);

    fs.stat(filePath, (err, stats) => {
        if (err || !stats.isFile()) {
            // Fall back to index.html for SPA/client routing
            const indexPath = path.join(WEB_DIR, 'index.html');
            fs.readFile(indexPath, (indexErr, data) => {
                if (indexErr) {
                    res.writeHead(404, { 'Content-Type': 'text/plain' });
                    res.end('File Not Found');
                } else {
                    res.writeHead(200, {
                        'Content-Type': 'text/html; charset=UTF-8',
                        'Cache-Control': 'no-cache, must-revalidate'
                    });
                    res.end(data);
                }
            });
            return;
        }

        const ext = path.extname(filePath).toLowerCase();
        const contentType = MIME_TYPES[ext] || 'application/octet-stream';
        const isStaticAsset = pathname.startsWith('/assets/');

        const headers = {
            'Content-Type': contentType,
            'Content-Length': stats.size,
            'X-Content-Type-Options': 'nosniff'
        };

        if (isStaticAsset) {
            headers['Cache-Control'] = 'public, max-age=86400, immutable';
        } else {
            headers['Cache-Control'] = 'no-cache, must-revalidate';
        }

        if (req.method === 'HEAD') {
            res.writeHead(200, headers);
            res.end();
            return;
        }

        res.writeHead(200, headers);
        const readStream = fs.createReadStream(filePath);
        readStream.pipe(res);
    });
});

server.listen(PORT, '0.0.0.0', () => {
    console.log(`[The Colours Tattoo Studio] Production Web Server listening on port ${PORT}`);
});

process.on('SIGINT', () => process.exit(0));
process.on('SIGTERM', () => process.exit(0));
