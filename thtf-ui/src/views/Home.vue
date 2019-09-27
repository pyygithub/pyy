<template>
  <div class="home-container">
    <!-- 导航菜单栏 -->
    <MenuBar></MenuBar>
    <!-- 头部区域 -->
    <HeadBar></HeadBar>
    <!-- 主内容区域 -->
    <Main></Main>
  </div>
</template>

<script type="text/ecmascript-6">
    import HeadBar from "./HeadBar/HeadBar"
    import MenuBar from "./MenuBar/MenuBar"
    import Main from "./Main/Main"
    export default {
        components:{
            HeadBar,
            MenuBar,
            Main
        }
    }
</script>

<style lang="stylus" rel="stylesheet/stylus">
  .home-container {
    position:absolute;
    top: 0px;
    left: 0px;
    right: 0px;
    background: #4b5f6e;
  }
</style>