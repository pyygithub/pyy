<template>
  <el-dropdown class="lang-selector" @command="handleCommand" trigger="click">
    <span class="el-dropdown-link">
        {{languageName}}<i class="el-icon-arrow-down el-icon--right"></i>
      </span>
    <el-dropdown-menu slot="dropdown">
      <el-dropdown-item command="zh_cn:中文">中文</el-dropdown-item>
      <el-dropdown-item command="en_us:English">English</el-dropdown-item>
    </el-dropdown-menu>
  </el-dropdown>
</template>


<script type="text/ecmascript-6">
  export default {
      data() {
          return {
              languageName: '中文'
          }
      },
      methods: {
        // 语言切换
        handleCommand(command) {
          let array = command.split(':')
          let lang = array[0] === '' ? 'zh_cn' : array[0]
          this.$i18n.locale = lang
          this.languageName = lang == 'en_us' ? 'English' : '中文'
        }
      }
  }
</script>