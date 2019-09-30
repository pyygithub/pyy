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

export const testConnection = (params) => {
  return axios({
    url:'/testConnection',
    method: 'post',
    data: params
  })
}

export const getGenerateModel = (params) => {
  return axios({
    url:'/getGenerateModel',
    method: 'post',
    data: params
  })
}

export const getTables = (params) => {
  return axios({
    url:'/getTables',
    method: 'post',
    data: params
  })
}

export const generateModels = (params) => {
  return axios({
    url:'/generateModels',
    method: 'post',
    data: params
  })
}


export default {
  login,
  getUser,
  testConnection,
  getGenerateModel,
  getTables,
  generateModels,
}
