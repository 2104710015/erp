<template>
  <div>
  <vxe-button status="primary" content="查询所有订单信息" @click="findOrders()"></vxe-button>
  <vxe-button status="primary" content="新增" @click="addOrder()"></vxe-button>
  <vxe-table
    height="495"
    :data="demo.orders">
    <vxe-column type="seq" width="60" field="id" title="编号"></vxe-column>
    <vxe-column field="ordernumber" title="订单编号"></vxe-column>
    <vxe-column field="orderdate" title="订货日期"></vxe-column>
    <vxe-column field="status" title="状态" :cell-class-name="getCellClassName"></vxe-column>
    <vxe-column field="number" title="销售合同"></vxe-column>
    <vxe-column field="pouringdate" title="计划浇筑时间"></vxe-column>
    <vxe-column field="concretemarkings" title="混凝土标记"></vxe-column>
    <vxe-column field="pouringmethod" title="浇筑方式"></vxe-column>
    <vxe-column field="customername" title="客户名称"></vxe-column>
    <vxe-column field="projectname" title="工程地址"></vxe-column>
    <vxe-column field="plannedsqueravolume" title="计划方量"></vxe-column>
    <vxe-column field="salesman" title="业务员"></vxe-column>
    <vxe-column title="操作" width="180">
      <template #default="{ row }">
        <vxe-button v-if="row.status!=='执行中'" status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
        <vxe-button v-if="row.status==='制单'" status="danger" icon="vxe-icon-delete" @click="deleteEvent(row)"></vxe-button>
      </template>
    </vxe-column>
  </vxe-table>
    <!--编辑-->
    <vxe-modal v-model="demo.status" :title=" '销售订单'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.updateData" title-align="right" title-width="100" >
        <vxe-form-item title="销售订单" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="ordernumber" title="订单编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.ordernumber" placeholder="订单编号" disabled></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="orderdate" title="订货日期" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.orderdate" placeholder="请输入订货日期 " type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="salescontractid" title="销售合同" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.salescontractid" :options="demo.optionsNew" placeholder="销售合同 "></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="pouringdate" title="计划浇筑时间" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pouringdate" placeholder="计划浇筑时间" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item title="混凝土标记" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="strengthlevel" title="强度等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.strengthlevel" :options="demo.options1" placeholder="强度等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="slump" title="坍落度" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.slump" :options="demo.options2" placeholder="坍落度"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="impermeabilitylevel" title="抗渗等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.impermeabilitylevel" :options="demo.options3" placeholder="抗渗等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="frostresistancelevel" title="抗冻等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.frostresistancelevel" :options="demo.options4" placeholder="抗冻等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="sulfateresistancelevel" title="抗硫酸盐等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.sulfateresistancelevel" :options="demo.options5" placeholder="抗硫酸盐等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="chlorideionresistancelevel" title="抗氯离子等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.chlorideionresistancelevel" :options="demo.options6" placeholder="抗氯离子等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="admixture" title="特殊原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.admixture" :options="demo.options7" placeholder="特殊原材料"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="specialrawmaterials" title="外加剂" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.specialrawmaterials" :options="demo.options8" placeholder="外加剂"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item title="发货计划" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="pouringmethod" title="浇筑方式" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.pouringmethod" :options="demo.options0" placeholder="浇筑方式">
            </vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="plannedsqueravolume" title="计划方量" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.plannedsqueravolume" placeholder="计划方量" type="integer"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="salesman" title="业务员" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.salesman" placeholder="业务员 "></vxe-input>
          </template>
        </vxe-form-item>

        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="saveEvent">保存</vxe-button>
            <vxe-button @click="submitEvent">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>

        <!--  新增弹窗-->
    <vxe-modal v-model="demo.addStatus" :title=" '销售订单'" width="800" min-width="600" min-height="300"  resize destroy-on-close>
      <vxe-form :data="demo.addData" title-align="right" title-width="100" >
        <vxe-form-item title="销售订单" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="ordernumber" title="订单编号" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.ordernumber" placeholder="订单编号"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="orderdate" title="订货日期" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.orderdate" placeholder="请输入订货日期 " type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="salescontractid" title="销售合同" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.number" :options="demo.optionsNew" placeholder="销售合同">
            </vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="pouringdate" title="计划浇筑时间" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.pouringdate" placeholder="计划浇筑时间" type="datetime"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item title="混凝土标记" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="strengthlevel" title="强度等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.strengthlevel" :options="demo.options1" placeholder="强度等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="slump" title="坍落度" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.slump" :options="demo.options2" placeholder="坍落度"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="impermeabilitylevel" title="抗渗等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.impermeabilitylevel" :options="demo.options3" placeholder="抗渗等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="frostresistancelevel" title="抗冻等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.frostresistancelevel" :options="demo.options4" placeholder="抗冻等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="sulfateresistancelevel" title="抗硫酸盐等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.sulfateresistancelevel" :options="demo.options5" placeholder="抗硫酸盐等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="chlorideionresistancelevel" title="抗氯离子等级" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.chlorideionresistancelevel" :options="demo.options6" placeholder="抗氯离子等级"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="admixture" title="特殊原材料" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.admixture" :options="demo.options7" placeholder="特殊原材料"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="specialrawmaterials" title="外加剂" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.specialrawmaterials" :options="demo.options8" placeholder="外加剂"></vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item title="发货计划" title-align="left" :title-width="200" :span="24" :title-prefix="{icon: 'vxe-icon-comment'}"></vxe-form-item>
        <vxe-form-item field="pouringmethod" title="浇筑方式" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-select v-model="data.pouringmethod" :options="demo.options0" placeholder="浇筑方式">
            </vxe-select>
          </template>
        </vxe-form-item>
        <vxe-form-item field="plannedsqueravolume" title="计划方量" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.plannedsqueravolume" placeholder="计划方量" type="integer"></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item field="salesman" title="业务员" :span="12" :item-render="{}">
          <template #default="{ data }">
            <vxe-input v-model="data.salesman" placeholder="业务员 "></vxe-input>
          </template>
        </vxe-form-item>
        <vxe-form-item align="center" title-align="left" :span="24">
          <template #default>
            <vxe-button @click="saveEvent1">保存</vxe-button>
            <vxe-button @click="addEvent">提交</vxe-button>
            <vxe-button type="reset">重置</vxe-button>
          </template>
        </vxe-form-item>
      </vxe-form>
    </vxe-modal>
  </div>
</template>
<!--<style>-->
<!--.custom-cell-class-name1 {-->
<!--  color: grey; /* 若数据中 age 字段为 "张三"，则字体颜色为蓝色 */-->
<!--}-->

<!--.custom-cell-class-name2 {-->
<!--  color: #0f0; /* 若数据中 age 字段为 "李四"，则字体颜色为绿色 */-->
<!--}-->
<!--</style>-->
<script>
import {reactive,onMounted} from "vue";
import request from "@/utils/request";
export default {
  name: "index",
  setup(){
    onMounted(() => {
      findOrders()
      findProductionsToOrder()
      findSalescontractsToOrder()
      findToOrder1()
      findToOrder2()
      findToOrder3()
      findToOrder4()
      findToOrder5()
      findToOrder6()
      findToOrder7()
      findToOrder8()
    })
    const demo = reactive({
      orders:[],
      optionsNew:[],
      options0:[],
      options1:[],
      options2:[],
      options3:[],
      options4:[],
      options5:[],
      options6:[],
      options7:[],
      options8:[],
      selectedPouringmethod:[],
      status: false,
      addStatus: false,
      updateData: [],
      addData: []
    })
    // const getCellClassName = async (row) =>{
    //   const status = row.status
    //   if(status==="制单"){
    //     return"custom-cell-class-name1";
    //   }
    //   else if(status==="执行中"){
    //     return "custom-cell-class-name2"
    //   }
    // }
    // const findAllConcretes = async () =>{
    //   console.log(111)
    //   const res = await request.get('/concrete/concrete/findAllConcretes');
    //   console.log(res)
    //   demo.concretes = res.data
    //   console.log(demo.concretes)
    //   return res
    // }
    const findOrders = async () =>{
      console.log(111)
      const res = await request.get('/order/order/findAllOrders');
      console.log(res)
      demo.orders = res.data
      console.log(demo.orders)
      return res
    }
    const findToOrder1 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder2');
      const data=res.data
      if (data && data.length > 0) {
        demo.options1 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder2 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder3');
      const data=res.data
      if (data && data.length > 0) {
        demo.options2 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder3 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder4');
      const data=res.data
      if (data && data.length > 0) {
        demo.options3 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder4 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder5');
      const data=res.data
      if (data && data.length > 0) {
        demo.options4 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder5 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder6');
      const data=res.data
      if (data && data.length > 0) {
        demo.options5 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder6 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder7');
      const data=res.data
      if (data && data.length > 0) {
        demo.options6 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder7 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder8');
      const data=res.data
      if (data && data.length > 0) {
        demo.options7 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findToOrder8 = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder9');
      const data=res.data
      if (data && data.length > 0) {
        demo.options8 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const findSalescontractsToOrder = async () =>{
      const res = await request.get('/salesContract/salescontract/findAllSalescontracts');
      const data=res.data
      if (data && data.length > 0) {
        demo.optionsNew = data.map(item => {
          return { value: item.salescontractid, label: item.number};
        });
      }
      return res
    }
    const findProductionsToOrder = async () =>{
      const res = await request.get('/production/production/findProductionsToOrder1');
      const data=res.data
      if (data && data.length > 0) {
        demo.options0 = data.map(item => {
          return { value: item.subproperty, label: item.subproperty};
        });
      }
      return res
    }
    const addOrder=async () => {
      demo.addStatus=true
    }
    const addEvent = async() => {
      demo.addStatus = false;
      let data={
        ordernumber:demo.addData.ordernumber,
        orderdate:demo.addData.orderdate,
        status:demo.addData.status,
        pouringdate: demo.addData.pouringdate,
        salescontractid:demo.addData.salescontractid,
        concretemarkings:demo.addData.concretemarkings,
        pouringmethod:demo.addData.pouringmethod,
        plannedsqueravolume:demo.addData.plannedsqueravolume,
        salesman:demo.addData.salesman,
        remarks:demo.addData.remarks,
        strengthlevel:demo.addData.strengthlevel,
        slump:demo.addData.slump,
        impermeabilitylevel: demo.addData.impermeabilitylevel,
        frostresistancelevel:demo.addData.frostresistancelevel,
        sulfateresistancelevel:demo.addData.sulfateresistancelevel,
        chlorideionresistancelevel:demo.addData.chlorideionresistancelevel,
        admixture:demo.addData.admixture,
        specialrawmaterials:demo.addData.specialrawmaterials
      }
      data.concretemarkings=data.strengthlevel+"-"+data.frostresistancelevel+
        data.impermeabilitylevel+data.sulfateresistancelevel+data.specialrawmaterials+data.admixture;
      data.status="执行中"
      console.log(data)
      const res=await request.post('/order/order/addOrder',data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const updateEvent=(row)=>{
      demo.status=true
      demo.updateData=row
    }
    const submitEvent=async () => {
      console.log(demo.updateData)
      demo.status=false
      let data=demo.updateData
      data.status="执行中"
      data.concretemarkings=data.strengthlevel+"-"+data.frostresistancelevel+
        data.impermeabilitylevel+data.sulfateresistancelevel+data.specialrawmaterials+data.admixture;
      const res = await request.put('/order/order/updateOrder',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }

    const deleteEvent=async (row) => {
      alert(row.id)
      const res = await request.delete('/order/order/deleteOrder/'+row.id)
      if (res.data.code==0){
        return res.data.message
      }
      reload()
      return Promise.reject((new Error(res.data.message)))
    }
    const saveEvent = async() => {
      demo.status=false
      let data=demo.updateData
      data.status = "制单"
      data.concretemarkings=data.strengthlevel+"-"+data.frostresistancelevel+
        data.impermeabilitylevel+data.sulfateresistancelevel+data.specialrawmaterials+data.admixture;
      const res = await request.put('/order/order/updateOrder',data);
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    const saveEvent1 = async() => {
      demo.addStatus = false;
      let data={
        ordernumber:demo.addData.ordernumber,
        orderdate:demo.addData.orderdate,
        status:demo.addData.status,
        pouringdate: demo.addData.pouringdate,
        salescontractid:demo.addData.salescontractid,
        concretemarkings:demo.addData.concretemarkings,
        pouringmethod:demo.addData.pouringmethod,
        plannedsqueravolume:demo.addData.plannedsqueravolume,
        salesman:demo.addData.salesman,
        remarks:demo.addData.remarks,
        strengthlevel:demo.addData.strengthlevel,
        slump:demo.addData.slump,
        impermeabilitylevel: demo.addData.impermeabilitylevel,
        frostresistancelevel:demo.addData.frostresistancelevel,
        sulfateresistancelevel:demo.addData.sulfateresistancelevel,
        chlorideionresistancelevel:demo.addData.chlorideionresistancelevel,
        admixture:demo.addData.admixture,
        specialrawmaterials:demo.addData.specialrawmaterials
      }
      data.concretemarkings=data.strengthlevel+"-"+data.frostresistancelevel+
        data.impermeabilitylevel+data.sulfateresistancelevel+data.specialrawmaterials+data.admixture;
      data.status="制单"
      console.log(data)
      const res=await request.post('/order/order/addOrder',data)
      console.log(demo.addData)
      if (res.data.code === 0) {
        return res.data.message;
      }
      return Promise.reject(new Error(res.data.message));
    }
    return{
      demo,
      findOrders,
      addOrder,
      addEvent,
      updateEvent,
      deleteEvent,
      submitEvent,
      saveEvent,
      saveEvent1,
      findSalescontractsToOrder,
      findProductionsToOrder,
      findToOrder1,
      findToOrder2,
      findToOrder3,
      findToOrder4,
      findToOrder5,
      findToOrder6,
      findToOrder7,
      findToOrder8,
      // getCellClassName
    }
  }
}
</script>

<style scoped>

</style>
