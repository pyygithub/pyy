// 将 axios 封装成插件，按插件方式引入

import apis from './interface'

const install = Vue => {
    if (install.installed) {
        return;
    }

    install.installed = true;

    Object.defineProperties(Vue.prototype, {
        // 注意，此处挂载在 Vue 原型的 $api 对象上
        $api: {
            get() {
                return apis;
            }
        }
    })
}

export default install