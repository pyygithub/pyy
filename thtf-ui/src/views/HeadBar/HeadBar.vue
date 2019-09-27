<template>
    <div class="head-bar-container">
        <!-- 导航菜单隐藏显示切换 -->
        <span class="collapse-switcher" @click.prevent="collapse1">
            <i class="el-icon-menu"></i>
        </span>
        <!-- 导航菜单 -->
        <span class="nav-bar">
          <el-menu :default-active="activeIndex" class="el-menu-demo" text-color="#fff"
                   active-text-color="#ffd04b" mode="horizontal" @select="selectNavBar()">
            <el-menu-item index="1" @click="$router.push('/')">{{$t("common.home")}}</el-menu-item>
            <el-menu-item index="2">{{$t("common.doc")}}</el-menu-item>
            <el-menu-item index="3">{{$t("common.msgCenter")}}</el-menu-item>
          </el-menu>
        </span>
        <span class="tool-bar">
          <!-- 主题切换 -->
          <ThemePicker class="theme-picker"></ThemePicker>
          <!-- 语言切换 -->
          <LangSelector class="lang-selector"></LangSelector>
          <!-- 用户信息 -->
          <el-dropdown class="user-info-dropdown" trigger="click">
            <span class="el-dropdown-link"><img :src="this.userAvatar" /> {{username}}</span>
            <el-dropdown-menu slot="dropdown">
              <el-dropdown-item>{{$t("common.myMsg")}}</el-dropdown-item>
              <el-dropdown-item>{{$t("common.config")}}</el-dropdown-item>
              <el-dropdown-item divided @click.native="logout">{{$t("common.logout")}}</el-dropdown-item>
            </el-dropdown-menu>
          </el-dropdown>
        </span>
    </div>
</template>

<script type="text/ecmascript-6">
    import ThemePicker from "@/components/ThemePicker"
    import LangSelector from "@/components/LangSelector"
    export default {
        components:{
            ThemePicker,
            LangSelector
        },
        data() {
            return {
                isCollapse: false,
                username: "admin",
                userAvatar: "https://api.auauz.net/avatar/5ca5b971e1548-20190927013118890.jpeg",
                activeIndex: '1'
            };
        },
        methods: {
            selectNavBar(key, keyPath) {
                console.log(key, keyPath)
            },
            // 折叠导航栏
            collapse1() {
                this.isCollapsed = !this.isCollapsed;
            },
            // 退出登录
            logout() {
                var _this = this;
                this.$confirm('确定退出吗?', '提示', {
                    type: 'warning'
                }).then(() => {
                    sessionStorage.removeItem('user')
                    this.$router.push('/login')
                }).catch(() => {})
            }

        },
        mounted() {
            let user = sessionStorage.getItem('user')
            if (user) {
                this.username = user;
                this.userAvatar = 'https://api.auauz.net/avatar/5ca5b971e1548-20190927013118890.jpeg'
            }
        }
    }
</script>

<style lang="stylus" rel="stylesheet/stylus">
    .head-bar-container {
        position: absolute;
        left: 200px;
        right: 0px;
        height: 60px;
        line-height: 60px;
        background: #4b5f6e;
        .collapse-switcher {
            width: 26px;
            padding-left: 10px;
            float: left;
            cursor: pointer;
            border-color: rgba(111, 123, 131, 0.8);
            border-left-width: 1px;
            border-left-style: solid;
            border-right-width: 1px;
            border-right-style: solid;
            color: white;
            background: #504e6180;
        }
        .nav-bar {
            margin-left: auto;
            float: left;
            .el-menu {
                background: #504e6180;
            }
        }
        .tool-bar {
            float: right;
            .theme-picker {
                padding-right: 10px;
            }
            .lang-selector {
                padding-right: 30px;
                font-size: 15px;
                color: #fff;
                cursor: pointer;
            }
            .user-info-dropdown {
                font-size: 20px;
                padding-right: 20px;
                color: #fff;
                cursor: pointer;
                img {
                    width: 40px;
                    height: 40px;
                    border-radius: 10px;
                    margin: 10px 0px 10px 10px;
                    float: right;
                }
            }
        }
    }
</style>