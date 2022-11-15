# WebPack
> 스크립트가 여러개 있을때 하나로 합쳐 주는 웹팩  
* 애플리케이션에 필요한 모든 파일(모듈)을 병합하고 압축해서 하나의 결과물(번들)을 생성해주는 도구
* npm i vue-loader -D  
→ dependencies 개발 배포시 사용 설정 '-D'
* node 환경에 require 사용
* Vue 환경에 import 사용
### webpack 설정 파일
> webpack.config.js
```JS
const VueLoaderPlugin = require('vue-loader/lib/plugin');
const path = require('path');

module.exports = {
  mode: 'development',
  devtool: 'eval',
  resolve: {
    extensions: ['.js', '.vue'],
  },
  entry: {
    app: path.join(__dirname, 'main.js'),
  },
  module: {
    rules: [{
      test: /\.vue$/,
      use: 'vue-loader',
    }],
  },
  plugins: [
    new VueLoaderPlugin(),
  ],
  output: {
    filename: '[name].js',
    path: path.join(__dirname, 'dist'),
  },
};
```
## npm
* npm은 Node Packaged Manager의 약자
* npm이라는 것은 Node.js로 만들어진 pagkage(module)을 관리해주는 툴
```JS
npm run build
```
