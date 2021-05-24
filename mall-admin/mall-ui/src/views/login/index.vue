<template>
<div>
    <el-card class="login-form-layout">
        <el-form
        autoComlete="on"
        :model="loginForm"
        :rules="loginRules"
        ref="loginForm"
        label-position="left">
        <div style="text-align: center">
            <svg-icon icon-class="login-mall" style="width: 56px;height: 56px;color: #409EFF"></svg-icon>
        </div>
        <h2 class="login-title color-main">mall-ui</h2>
        <el-form-item prop="username">
            <el-input 
            name="username"
            type="text"
            v-model="loginForm.username"
            autoComplete="on"
            placeholder="请输入用户名">
        <span slot="prefix">
            <svg-icon icon-class="user" class="color-main"></svg-icon>
            </span>   
            </el-input>
        </el-form-item>
        
        </el-form>

    </el-card>
</div>
</template>