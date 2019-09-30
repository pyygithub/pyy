import Vue from 'vue'
import App from './App'
import router from './router'
import store from './store'
import i18n from './i18n'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'
import api from './http/index'


Vue.use(ElementUI)
Vue.use(api)

Vue.config.productionTip = false

new Vue({
  el: '#app',
  i18n,
  router,
  store,
  render: h => h(App)
});
