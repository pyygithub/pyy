import Vue from 'vue'
import Router from 'vue-router'
import config from './http/config'

Vue.use(Router)

const router = new Router({
  mode: 'history',
  base: config.baseURL,
  routes: [
    {
      path: '/',
      component: () => import(/* webpackChunkName: "about" */ './views/Home.vue'),
      children: [
          { path: ''    , name: '系统介绍', component: () => import(/* webpackChunkName: "about" */ '@/views/SysManage/Intro') },
          { path: '/user', name: '用户管理', component: () => import(/* webpackChunkName: "about" */ '@/views/SysManage/User') },
          { path: '/dept', name: '机构管理', component: () => import(/* webpackChunkName: "about" */ '@/views/SysManage/Dept') },
          { path: '/role', name: '角色管理', component: () => import(/* webpackChunkName: "about" */ '@/views/SysManage/Role') },
          { path: '/menu', name: '菜单管理', component: () => import(/* webpackChunkName: "about" */ '@/views/SysManage/Menu')},
          { path: '/log' , name: '日志管理', component: () => import(/* webpackChunkName: "about" */ '@/views/SysManage/Log') }
      ]
    },
    {
      path: '/login',
      name: 'login',
      component: () => import(/* webpackChunkName: "about" */ './views/Login.vue')
    },
    {
        path: '/404',
        name: 'notFound',
        component: () => import(/* webpackChunkName: "about" */ './views/Error/404.vue')
    }
  ]
})

// // 路由守卫
// router.beforeEach((to, from, next) => {
//     // 登录页面登录成功之后，会把会话信息保存在 sessionStorage中
//     // 存在时间为会话生命周期，页面关闭即失效
//     let user = sessionStorage.getItem('user')
//     if (to.path == '/login') {
//         // 如果访问登录页面，如果用户会话信息存在，代表已经登录过，跳转到主页
//         if (user) {
//           next({path: '/'})
//         } else {
//           next()
//         }
//     } else {
//         // 如果访问非登录页面，且用户会话信息不存在，代表未登录，则跳转到登录页面
//         if (!user) {
//           next({path: '/login'})
//         } else {
//           next()
//         }
//
//     }
// })


export default router;