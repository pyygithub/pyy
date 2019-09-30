import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    ,{
      path: '/',
      name: '首页',
      component: () => import('@/views/Home'),
    },
    {
      path: '/',
      name: '首页',
      component: () => import('@/views/Home'),
      children: [
        {
          path: 'intro', name: '系统介绍', component: () => import('@/views/Intro/Intro')
        },
        {
          path: 'single',
          name: '单表查询',
          component: () => import('@/views/Generate/SingleTable'),
        },
        {
          path: 'master',
          name: '主从表格',
          component: () => import('@/views/Generate/MasterTable')
        }
      ]
    }
    ,{
      path: '/404',
      name: 'notFound',
      component: () => import('@/views/Error/404')
    },
    ,{
      path: '/login',
      name: 'login',
      component: () => import('@/views/Login')
    }
  ]
})
