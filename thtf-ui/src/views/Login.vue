<template>
    <div class="login">
        <el-form :model="loginForm" :rules="fieldRules" ref="loginForm" label-position="left" label-width="0px" class="demo-ruleForm login-container">
            <h3 class="title">系统登录</h3>
            <el-form-item prop="username">
                <el-input type="text" v-model="loginForm.username"  prefix-icon="el-icon-user" auto-complete="off" placeholder="账号"></el-input>
            </el-form-item>
            <el-form-item prop="password">
                <el-input type="password" v-model="loginForm.password" prefix-icon="el-icon-lock" auto-complete="off" placeholder="密码"></el-input>
            </el-form-item>
            <el-checkbox v-model="checked" checked class="remember">记住密码</el-checkbox>
            <el-form-item style="width:100%;">
                <el-button type="primary" style="width:48%;" @click.native.prevent="reset">重 置</el-button>
                <el-button type="primary" style="width:48%;" @click.native.prevent="login" :loading="logining">登 录</el-button>
            </el-form-item>
        </el-form>
    </div>
</template>

<script type="text/ecmascript-6">
    import {setToken} from '@/http/auth'

    export default {
        name: 'Login',
        data() {
            return {
                logining: false,
                loginForm: {
                    username: 'admin',
                    password: '123456',
                },
                fieldRules: {
                    username: [
                        {required: true, message: '请输入用户名', trigger: 'blur'},
                    ],
                    password: [
                        {required: true, message: '请输入密码', trigger: 'blur'},
                    ],
                },
                checked: true
            }
        },
        methods: {
            async login() {
                let userInfo = {username: this.loginForm.username, password: this.loginForm.password}
                let res = await this.$api.login(JSON.stringify(userInfo))
                setToken(res.data.token);
                sessionStorage.setItem('user', userInfo.username)
                this.$router.push("/") // 登录成功，跳转到主页
            },
            reset() {
                this.$refs.loginForm.resetFields();
            }
        }
    }
</script>

<style lang="stylus" rel="stylesheet/stylus">
    .login {
        display: -webkit-box;
        display: -ms-flexbox;
        display: flex;
        -webkit-box-pack: center;
        -ms-flex-pack: center;
        justify-content: center;
        -webkit-box-align: center;
        -ms-flex-align: center;
        align-items: center;
        height: 100%;
        background-image: url(https://docs-1255840532.cos.ap-shanghai.myqcloud.com/3968.jpg);
        background-size: cover;
    }
    .login-container {
        border-radius: 6px;
        background: #fff;
        width: 400px;
        padding: 25px 25px 5px;
        text-align: left;
        .title {
            margin: 0px auto 40px auto;
            text-align: center;
            color: #505458;
        }
        .remember {
            margin: 0px 0px 35px 0px;
        }
    }
</style>