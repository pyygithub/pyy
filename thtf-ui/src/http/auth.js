import cookies from 'js-cookie'
import config from './config'

const tokenKey = config.tokenKey

export const getToken = () => {
  return cookies.get(tokenKey)
}

export const setToken = (token, rememberMe) => {
  if (rememberMe) {
    return cookies.set(TokenKey, token, { expires: config.tokenCookieExpires })
  } else {
    return cookies.set(TokenKey, token)
  }
}

export const removeToken = () => {
  return cookies.remove(TokenKey)
}
