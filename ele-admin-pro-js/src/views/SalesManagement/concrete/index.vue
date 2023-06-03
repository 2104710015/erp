<template>
<div>
  <vxe-table
    :data="demo.concretes">
    <vxe-column type="seq" width="60" field="salescontractid" title="编号"></vxe-column>
    <vxe-column field="ordernumber" title="订单编号"></vxe-column>
    <vxe-column field="strengthlevel" title="强度等级"></vxe-column>
    <vxe-column field="slump" title="坍落度"></vxe-column>
    <vxe-column field="impermeabilitylevel" title="抗渗等级"></vxe-column>
    <vxe-column field="frostresistancelevel" title="抗冻等级"></vxe-column>
    <vxe-column field="sulfateresistancelevel" title="抗硫酸盐等级"></vxe-column>
    <vxe-column field="chlorideionresistancelevel" title="抗氯离子等级"></vxe-column>
    <vxe-column field="admixture" title="外加剂"></vxe-column>
    <vxe-column field="specialrawmaterials" title="特殊原材料"></vxe-column>
    <vxe-column title="操作" width="180">
      <template #default="{ row }">
        <vxe-button status="warning" content="编辑" @click="updateEvent(row)"></vxe-button>
      </template>
    </vxe-column>
  </vxe-table>
</div>
</template>

<script>
import {onMounted, reactive} from "vue";
import request from "@/utils/request";

export default {
  name: "index",
  setup(){
    onMounted(() => {
      findAllConcretes()
    })
    const demo = reactive({
      concretes: [],
    })
    const findAllConcretes = async () =>{
      console.log(111)
      const res = await request.get('/concrete/concrete/findAllConcretes');
      console.log(res)
      demo.concretes = res.data
      console.log(demo.concretes)
      return res
    }
    return{
      demo,
      findAllConcretes
    }
  }
}
</script>

<style scoped>

</style>
