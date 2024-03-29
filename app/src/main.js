// The Vue build version to load with the `import` command
// (runtime-only or standalone) has been set in webpack.base.conf with an alias.
import Vue from 'vue'

import VueFire from 'vuefire'

// Import F7
/* eslint-disable no-unused-vars */
import Framework7 from 'framework7'

// Import F7 Vue Plugin
import Framework7Vue from 'framework7-vue'

// Import F7 iOS Theme Styles
/* eslint-disable no-unused-vars */
// /home/daniel/development/projects/hackathon-fluig/app/node_modules/framework7/dist/css/framework7.md.min.css
import Framework7Theme from 'framework7/dist/css/framework7.material.css'
import Framework7ThemeColors from 'framework7/dist/css/framework7.material.colors.min.css'
// Import App Custom Styles
// import AppStyles from './css/app.css'

// Import Routes
import Routes from './routes.js'

import App from './App'


// Init F7 Vue Plugin
Vue.use(Framework7Vue)

// Init VueFire Vue Plugin
Vue.use(VueFire)

/* eslint-disable no-new */
// Init App
new Vue({
  el: '#app',
  template: '<app/>',
  framework7: {
    root: '#app',
    material: true,
    routes: Routes
  },
  components: {
    app: App
  }
})
