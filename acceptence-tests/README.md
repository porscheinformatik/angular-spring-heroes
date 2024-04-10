# Acceptance Tests

These are the acceptance tests for Angular Spring Heroes. The tests are written in [Playwright](https://playwright.dev/).

## Running

After the initial clone or after updates run `npm install`.

Run all tests with `npm test`.

If you want to run single tests or debug them use the [Playwright VSCode extension](vscode:extension/ms-playwright.playwright).

### Hints

For Safari on Ubuntu 22.10 you will have to install the following packages:

```
sudo apt install libvpx7 libevent-2.1-7a libgles2 libx264-dev libmanette-0.2-0 libhyphen0 libenchant-2-2 libgstreamer-plugins-base1.0-0 libopengl0 libwoff1 libharfbuzz-icu0 libgstreamer-gl1.0-0
wget http://archive.ubuntu.com/ubuntu/pool/main/i/icu/libicu70_70.1-2_amd64.deb
sudo apt install libicu70_70.1-2_amd64.deb
```
