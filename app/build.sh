npm run build
rm -rf cordova/www
mkdir -p cordova/www
cp -R dist/* cordova/www/
