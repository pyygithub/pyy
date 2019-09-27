// 请求接口汇总模块，聚合模块 API。
import axios from './axios'

export const login = () => {
    return axios({
        url: '/login',
        method: 'get'
    })
}

export const getUser = () => {
    return axios({
        url:'/user',
        method: 'get'
    })
}


export default {
    login,
    getUser,
}