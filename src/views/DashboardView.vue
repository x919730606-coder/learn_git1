<script setup>
import {
  Aim, Coin,
  CreditCard, DataAnalysis, Grid,
  Magnet, Memo, OfficeBuilding,
  Paperclip, Postcard, Setting, SetUp, Tools,
  User, UserFilled, Wallet
} from "@element-plus/icons-vue";

function handleOpen() {
  console.log("菜单展开了")
}

function handleClose() {
  console.log("菜单收起来了")
}
</script>

<template>
  <el-container>
    <!--左侧-->
    <el-aside width="200px">
      <div class="asideTitile">动力云客系统</div>
      <!--
        active-text-color: 活动菜单项的文本颜色
        background-color: 菜单的背景颜色
        default-active: 页面加载时默认激活菜单的index
        text-color: 菜单的文字颜色
        unique-opened: 是否只保持一个子菜单的展开，默认是false
        @open: sub-menu展开的回调
        @closeL sub-menu收起的回调
      -->
      <el-menu
          active-text-color="#ffd04b"
          background-color="#545c64"
          default-active="3-1"
          text-color="#fff"
          unique-opened
          style="border-right: 0 solid"
          v-on:open="handleOpen()"
          v-on:close="handleClose">

        <!--1、市场活动菜单-->
        <!--
          index: 唯一标志
        -->
        <el-sub-menu index="1">
          <template #title>
            <el-icon><OfficeBuilding /></el-icon>
            <span>市场活动</span>
          </template>
          <!--
            index: 唯一标志
          -->
          <el-menu-item index="1-1"><el-icon><Aim /></el-icon>市场活动</el-menu-item>
          <el-menu-item index="1-2"><el-icon><CreditCard /></el-icon>市场统计</el-menu-item>
        </el-sub-menu>

        <!--2、线索管理菜单-->
        <el-sub-menu index="2">
          <template #title>
            <el-icon><Magnet /></el-icon>
            <span>线索管理</span>
          </template>
          <el-menu-item index="2-1"><el-icon><Paperclip /></el-icon>线索管理</el-menu-item>
          <el-menu-item index="2-2"><el-icon><CreditCard /></el-icon>线索统计</el-menu-item>
        </el-sub-menu>

        <!--3、客户管理菜单-->
        <el-sub-menu index="3">
          <template #title>
            <el-icon><User /></el-icon>
            <span>客户管理</span>
          </template>
          <el-menu-item index="3-1"><el-icon><UserFilled /></el-icon>客户管理</el-menu-item>
          <el-menu-item index="3-2"><el-icon><CreditCard /></el-icon>客户统计</el-menu-item>
        </el-sub-menu>

        <!--4、交易管理菜单-->
        <el-sub-menu index="4">
          <template #title>
            <el-icon><Wallet /></el-icon>
            <span>交易管理</span>
          </template>
          <el-menu-item index="4-1"><el-icon><Coin /></el-icon>交易管理</el-menu-item>
          <el-menu-item index="4-2"><el-icon><CreditCard /></el-icon>交易统计</el-menu-item>
        </el-sub-menu>

        <!--5、产品管理菜单-->
        <el-sub-menu index="5">
          <template #title>
            <el-icon><Memo /></el-icon>
            <span>产品管理</span>
          </template>
          <el-menu-item index="5-1"><el-icon><SetUp /></el-icon>产品管理</el-menu-item>
          <el-menu-item index="5-2"><el-icon><CreditCard /></el-icon>产品统计</el-menu-item>
        </el-sub-menu>

        <!--6、字典管理菜单-->
        <el-sub-menu index="6">
          <template #title>
            <el-icon><Grid /></el-icon>
            <span>字典管理</span>
          </template>
          <el-menu-item index="6-1"><el-icon><Postcard /></el-icon>字典管理</el-menu-item>
          <el-menu-item index="6-2"><el-icon><DataAnalysis /></el-icon>字典统计</el-menu-item>
        </el-sub-menu>

        <!--7、用户管理菜单-->
        <el-sub-menu index="7">
          <template #title>
            <el-icon><User /></el-icon>
            <span>用户管理</span>
          </template>
          <el-menu-item index="7-1"><el-icon><UserFilled /></el-icon>用户管理</el-menu-item>
          <el-menu-item index="7-2"><el-icon><CreditCard /></el-icon>用户统计</el-menu-item>
        </el-sub-menu>

        <!--8、系统管理菜单-->
        <el-sub-menu index="8">
          <template #title>
            <el-icon><Setting /></el-icon>
            <span>系统管理</span>
          </template>
          <el-menu-item index="8-1"><el-icon><Tools /></el-icon>系统管理</el-menu-item>
          <el-menu-item index="8-2"><el-icon><CreditCard /></el-icon>系统统计</el-menu-item>
        </el-sub-menu>
      </el-menu>
    </el-aside>

    <!--右侧-->
    <el-container>
      <!--右侧顶部-->
      <el-header>Header</el-header>
      <!--右侧内容体-->
      <el-main>Main</el-main>
      <!--右侧底部-->
      <el-footer>
        @版权所有 动力节点 2009-2099 北京市通州区景盛南二街纳特大厦7层711
      </el-footer>
    </el-container>
  </el-container>
</template>

<style scoped>
.el-aside {
  background: #1a1a1a;
  height: calc(100vh);
}
.el-header {
  background: azure;
  height: 35px;
}
.el-footer {
  background: aliceblue;
  height: 40px;
  line-height: 40px;
  text-align: center;
}
.asideTitile {
  color: #f8f8f8;
  text-align: center;
  height: 35px;
  line-height: 35px;
}
</style>