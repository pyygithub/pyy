<template>
    <div class="menu-bar-container">
        <!-- logo -->
        <div class="logo" :class="isCollapse?'menu-bar-collapse-width':'menu-bar-width'">
            <img :src="this.logo" /> <div>{{isCollapse ? '' :sysName}}</div>
        </div>
        <!-- 导航菜单 -->
        <el-menu default-active="1-1" :class="isCollapse?'menu-bar-collapse-width':'menu-bar-width'" @open="handleopen" @close="handleclose" @select="handleselect" :collapse="isCollapse">
            <el-submenu index="1">
                <template slot="title">
                    <i class="el-icon-location"></i>
                    <span slot="title">{{$t("sys.sysMng")}}</span>
                </template>
                <el-menu-item index="1-1" @click="$router.push('user')">{{$t("sys.userMng")}}</el-menu-item>
                <el-menu-item index="1-2" @click="$router.push('dept')">{{$t("sys.deptMng")}}</el-menu-item>
                <el-menu-item index="1-3" @click="$router.push('role')">{{$t("sys.roleMng")}}</el-menu-item>
                <el-menu-item index="1-4" @click="$router.push('menu')">{{$t("sys.menuMng")}}</el-menu-item>
                <el-menu-item index="1-5" @click="$router.push('log')">{{$t("sys.logMng")}}</el-menu-item>
            </el-submenu>
        </el-menu>
    </div>
</template>

<script type="text/ecmascript-6">
    export default {
        data() {
            return {
                isCollapse: false,
                sysName: "",
                logo: "",
            };
        },
        methods: {
            handleopen() {
                console.log('handleopen')
            },
            handleclose() {
                console.log('handleclose')
            },
            handleselect() {
                console.log('handleselect')
            }
        },
        mounted() {
            this.sysName = "后台管理系统";
            this.logo = require("@/assets/logo.png");
        }
    }
</script>

<style lang="stylus" rel="stylesheet/stylus">
    .menu-bar-container {
        background: #4b5f6e;
        .el-menu {
            position:absolute;
            top: 60px;
            bottom: 0px;
            text-align: left;
        }
        .logo {
            position:absolute;
            top: 0px;
            height: 60px;
            line-height: 60px;
            background: #4b5f6e;
            img {
                width: 40px;
                height: 40px;
                border-radius: 0px;
                margin: 10px 10px 10px 10px;
                float: left;
            }
            div {
                font-size: 22px;
                color: white;
                text-align: left;
            }
        }
        .menu-bar-width {
            width: 200px;
        }
        .menu-bar-collapse-width {
            width: 65px;
        }
    }
</style>