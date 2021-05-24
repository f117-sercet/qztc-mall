<template>
<div class="app-container">
<div class="total-layout">
<el-row :gutter="20">
    <el-col :span="6">
        <div class="total-frame">
        <img :src="img_home_order" class="total_icon">
        <div class="total-title">今日订单总数</div>
        <div class="total-value">200</div>
        </div>
    </el-col>
    <el-col :span="6">
      <div class="total-frame">
          <img :src="img_home_today_amount" class="total-icon">
          <div class="total-title">今日销售总额</div>
          <div class="total-value">Y3000.00</div>
          </div>  
    </el-col>
</el-row>
</div>
<div class="un-handle-layout">
<div class="layout-title">待处理事务</div>
<div class="un-handle-content">
<el-row :gutter="20">
    <el-col :span="8">
        <div class="un-handle-item">
        <span class="font-medium">待付款订单</span>
        <span style="float:right" class="color-danger">(20)</span>
        </div>
    </el-col>
     <el-col :span="8">
         <div class="un-handle-item">
             <span class="font-medium">已完成订单</span>
             <span style="float: right" class="color-danger">(20)</span>
         </div>
     </el-col>
     <el-col :span="8">
     <div class="un-handle-item">
         <span class="font-medium">待确认收货</span>
         <span style="float: right" class="color-danger">(20)</span>
         </div>  
     </el-col>
     <el-col :span="8">
     <div class="un-handle-item">
              <span class="font-medium">新缺货登记</span>
              <span style="float: right" class="color-danger">(10)</span>
            </div>
     </el-col>
     <el-col :span="8">
     <div class="un-handle-item">
      <span class="font-medium">待处理退款申请</span>
      <span style="float: right" class="color-danger">(10)</span>
     </div>
     </el-col>
</el-row>
 <el-row :gutter="20">
<el-col :span="8">
<div class="un-handle-item">
    <span class="font-medium">已发货订单</span>
     <span style="float: right" class="color-danger">(10)</span>
</div>
</el-col>
<el-col :span="8">
            <div class="un-handle-item">
              <span class="font-medium">待处理退货订单</span>
              <span style="float: right" class="color-danger">(10)</span>
            </div>
          </el-col>
          <el-col :span="8">
            <div class="un-handle-item">
              <span class="font-medium">广告位即将到期</span>
              <span style="float: right" class="color-danger">(10)</span>
            </div>
          </el-col>
 </el-row>
</div>
</div>
<div class="overview-layout">
    <el-row :gutter="20">
        <el-col :span="12">
            <div class="out-border">
             <div class="layout-title">商品总览</div>
             <div style="padding: 40px">
              <el-row>
                <el-col :span="6" class="color-danger overview-item-value">100</el-col>
                <el-col :span="6" class="color-danger overview-item-value">400</el-col>
                <el-col :span="6" class="color-danger overview-item-value">50</el-col>
                <el-col :span="6" class="color-danger overview-item-value">500</el-col>
              </el-row>
              <el-row class="font-medium">
                <el-col :span="6" class="overview-item-title">已下架</el-col>
                <el-col :span="6" class="overview-item-title">已上架</el-col>
                <el-col :span="6" class="overview-item-title">库存紧张</el-col>
                <el-col :span="6" class="overview-item-title">全部商品</el-col>
              </el-row>
             </div>
            </div>
        </el-col>
       <el-col :span="12">
           <div class="out-border">
            <div class="layout-title">用户总览</div>
            <div style="padding: 40px">
                <el-row>
                  <el-col :span="6" class="color-danger overview-item-value">100</el-col>
                <el-col :span="6" class="color-danger overview-item-value">200</el-col>
                <el-col :span="6" class="color-danger overview-item-value">1000</el-col>
                <el-col :span="6" class="color-danger overview-item-value">5000</el-col>  
                </el-row>
                <el-row class="font-medium">
                <el-col :span="6" class="overview-item-title">今日新增</el-col>
                <el-col :span="6" class="overview-item-title">昨日新增</el-col>
                <el-col :span="6" class="overview-item-title">本月新增</el-col>
                <el-col :span="6" class="overview-item-title">会员总数</el-col>
              </el-row>
            </div>
           </div>
       </el-col>
    </el-row>
</div>
<div class="statistics-layout">
 <div class="layout-title">订单统计</div>
 <el-row>
     <el-col :span="4">
     <div style="padding: 20px">
     <div>
        <div style="color: #909399;font-size: 14px">本月订单总数</div>
        <div style="color: #606266;font-size: 24px;padding: 10px 0">10000</div>
      <div>
      <span class="color-success" style="font-size: 14px">+10%</span>
                <span style="color: #C0C4CC;font-size: 14px">同比上月</span>
    </div>   
     </div>
     
     </div>
     </el-col>
 </el-row>
</div>
</div>
</template>
    
