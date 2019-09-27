// axios 默认配置，包含基础路径等信息。

export default {
    method: 'get',
    // 基础url前缀
    baseURL: 'http://localhost:8080/',
    // token
    tokenKey: 'Authorization',
    // token超时时间
    tokenCookieExpires: 2 * 60 * 1000,
    // 请求头信息
    headers: {
        'Content-Type': 'application/json;charset=UTF-8'
    },
    // 参数
    data: {},
    // 设置超时时间，单位毫秒
    timeout: 10000,
    // 携带凭证: axios默认是请求的时候不会带上cookie的，需要通过设置 withCredentials:true来解决
    withCredentials: true,
    // 返回数据类型
    responseType: 'json'
}