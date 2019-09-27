import Vue from 'vue'
import App from './App.vue'
import router from './router'
import store from './store'
import ElementUI from 'element-ui'
import 'element-ui/lib/theme-chalk/index.css'
import 'font-awesome/css/font-awesome.min.css'
import api from './http/index'
import i18n from './i18n'

Vue.config.productionTip = false

Vue.use(ElementUI);
Vue.use(api)

new Vue({
    router,
    store,
    i18n,
    render: h => h(App)
}).$mount('#app')
