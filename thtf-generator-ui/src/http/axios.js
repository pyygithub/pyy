// 二次封装 axios 模块，包含拦截器等信息。
import axios from 'axios'
import config from './config'
import qs from 'qs'
import router from '@/router'
import { getToken } from '../utils/auth'


// 创建axios实例 axiso的一些基础参数配置,
const instance = axios.create({
    baseURL: config.baseURL,
    headers: config.headers,
    // `transformResponse` 在传递给 then/catch 前，允许修改响应数据
    // transformResponse: [function (data) {
    //     // 对 data 进行任意转换处理
    //
    // }]
})

const tokenKey = config.tokenKey
// request拦截器
instance.interceptors.request.use(
    config => {
        // 打开loading
        // store.commit('CONTROL_LOADING', true)
        // if (store.getters.token) {
        //     config.headers[tokenKey] = getToken() // 让每个请求携带token--['X-Token']为自定义key 请根据实际情况自行修改
        // }

        return config
    },

    // 请求错误时一般http状态码为两种以4开头，401：超时、404：not found 没找到接口
    error => {
        console.log('request error:' + error);
        // 在调用的那边可以拿到(catch)你想返回的错误信息
        return Promise.reject(error)
    }
)

// 响应拦截器
instance.interceptors.response.use(

    // 如果返回的状态码为200，
    res => {
        // 请求成功是要做的处理

        // 对响应数据做些事情，把loading 动画关掉
        // store.commit('CONTROL_LOADING', false)

        // 对请求成功的值做统一判断
        // 1. 判空
        if (res.data === '' || res.data.length === 0 || res.data === 'undefined' || res.data === undefined) {
            console.log('后台传来的data为空/为undefined')
        }

        // 2.错误提示(前提是接口跑通了，只是对里边某些值做下详细判断。要先跟后台商定好，对某个固定的字段进行判断，并且确定固定字段来承接 错误信息，方便展示)
        if (res.data.code && res.data.code !== 200) {
          console.log(res.data)
        }

        return res.data;
    },
    // 请求错误时做些事(接口错误、超时等)
    error => {

        // 关闭loading
        // store.commit('CONTROL_LOADING',false)
        console.log(error) // 打开控制台，可以看到error包含了几个对象:message, config, code, request, response,可以拿来请求超时等问题

        // 1. 判断请求超时
        if (error.code === 'ECONNABORTED' && error.message.indexOf('timeout') !== -1) {
            console.log('根据你设置的timeout/真的请求超时 判断请求现在超时了，你可以在这里加入超时的处理方案')
            // return service.request(originalRequest);//例如再重复请求一次
        }

        // 2. 需要重定向到错误页面
        if (error && error.response) {
            switch (error.response.status) {
                case 400: error.message = '请求错误(400)'; break;
                case 401: error.message = '未授权，请重新登录(401)'; break;
                case 403: error.message = '拒绝访问(403)'; break;
                case 404: router.push('/404'); break;
                case 408: error.message = '请求超时(408)'; break;
                case 500: error.message = '服务器错误(500)'; break;
                case 501: error.message = '服务未实现(501)'; break;
                case 502: error.message = '网络错误(502)'; break;
                case 503: error.message = '服务不可用(503)'; break;
                case 504: error.message = '网络超时(504)'; break;
                case 505: error.message = 'HTTP版本不受支持(505)'; break;
                default: error.message = `连接出错(${err.response.status})!`;
            }
        } else {
            error.message = '连接服务器失败!'
        }

        return Promise.reject(error) // 在调用的那边可以拿到(catch)你想返回的错误信息
    }
)

export default instance
