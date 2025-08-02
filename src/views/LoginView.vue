<script setup>

</script>

<template>
  <el-container>
    <!--左侧--> <!--运行后：<aside class="el-aside" style="--el-aside-width: 200px;"> Aside </aside> -->
    <el-aside width="200px">
      <img class="loginImg" src="../assets/login.png">
      <div class="loginTitle">欢迎使用动力云客系统</div>
    </el-aside>

    <!--右侧-->
    <el-main>
      <div class="welcome">欢迎登录</div>
     
      <el-form label-width="55px" style="width: 60%; margin: auto;" >
        <el-form-item label="账号" >
          <el-input  />
        </el-form-item>
        <el-form-item label="密码">
          <el-input  />
        </el-form-item>

        <el-form-item>
          <el-button type="primary">登 录</el-button>
        </el-form-item>
      </el-form>
    </el-main>
  </el-container>
</template>

<style scoped>
.el-aside {
  background: #1a1a1a;
  height: calc(100vh);
  width: 40%;
  text-align: center;
}
.loginImg {
  margin-top: 100px;
  margin-bottom: 50px;
  width: 500px;
}
.loginTitle {
  color: #f8f8f8;
  font-size: 28px;
}
.el-main {
  text-align: center;
  padding-top: 100px;
}
.welcome {
  margin-bottom: 30px;
  font-weight: bold;
}
.el-button {
  width: 100%;
}
</style>