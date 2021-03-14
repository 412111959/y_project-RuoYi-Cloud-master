<template>
  <div>
    <h1>这里是标题</h1>
    <el-table
      :data="showDeptList"
      border
      style="width: 97%;margin-left: 20px;margin-right: 20px;">
      <el-table-column prop="deptName" label="部门名称" width="260"></el-table-column>
      <el-table-column prop="orderNum" label="排序" width="200"></el-table-column>
      <el-table-column prop="status" label="状态"  width="100"></el-table-column>
      <el-table-column prop="createTime" label="创建日期" width="100"></el-table-column>
      <el-table-column label="操作" align="center" class-name="small-padding fixed-width">
        <template slot-scope="scope">
        <el-button
          size="mini"
          type="text"
          icon="el-icon-edit"
          @click="editDept(scope.row.deptId)"
          v-hasPermi="['system:dept:edit']"
        >
          修改</el-button>
        <el-button
          size="mini"
          type="text"
          icon="el-icon-plus"
          @click="addDept()"
          v-hasPermi="['system:dept:add']"
        >
          增加</el-button>
        <el-button
          size="mini"
          type="text"
          icon="el-icon-delete"
          @click="deleteDept(scope.row)"
          v-hasPermi="['system:dept:delete']"
        >
          删除</el-button>
        </template>
      </el-table-column>
    </el-table>

    <pagination
      v-show="total>0"
      :total="total"
      :page.sync="queryParams.pageNum"
      :limit.sync="queryParams.pageSize"
      @pagination="getList"
    />
<!--    修改、新增 对话框-->
    <el-dialog
      :title="title"
      :visible.sync="dialogVisible"
      width="30%"
      center>
      <el-form ref="form" :model="form" label-width="80px" append-to-body>
        <el-form-item label="部门名称">
          <el-input v-model="form.deptName"></el-input>
        </el-form-item>
        <el-form-item label="负责人">
          <el-input v-model="form.leader"></el-input>
        </el-form-item>
        <el-form-item label="联系电话">
          <el-input v-model="form.phone"></el-input>
        </el-form-item>
        <el-form-item label="显示排序" prop="orderNum">
          <el-input-number v-model="form.orderNum" controls-position="right" :min="0" />
        </el-form-item>

      </el-form>
      <span slot="footer" class="dialog-footer">
        <el-button @click="cancel()">取 消</el-button>
        <el-button type="primary" @click="submitForm()">确 定</el-button>
      </span>
    </el-dialog>
  </div>

</template>

<script>
    import { listDept,selectDept,updateDept,deleteDept,addDept} from "@/api/light/dept";
    import Treeselect from "@riophae/vue-treeselect";
    import "@riophae/vue-treeselect/dist/vue-treeselect.css";
    export default {
        name: "index.vue",
        components: { Treeselect },
        data(){
            return {
              typeList:[],
              total:0,
              showDeptList:[],//展示数据
              deptList : [],//原始部门列表
              loading : true,
              dialogVisible:false,
              form:{},
              title:"",
              queryParams: {
                  pageNum: 1,
                  pageSize: 5,
                  dictName: undefined,
                  dictType: undefined,
                  status: undefined
              },
            }
        },
        mounted(){
          this.getList();
        },
        methods:{
            getList(){
                this.loading = true;
                listDept(null).then((response)=>{
                    // console.log(response);
                    // this.deptList = response.data;//接收数据
                    // this.showDeptList = JSON.parse(JSON.stringify(response.data))//展示数据
                    // console.log(response)

                    // this.deptList = response.rows;//接收数据
                    this.showDeptList = response.rows;//接收数据
                    // this.showDeptList = JSON.parse(JSON.stringify(response.rows))//展示数据
                    this.total = response.total;
                    this.loading = false;
                }).catch((error)=>{
                    console.log(error)
                })
            },
            //新增部门
            addDept(){
                this.title="新增部门"
                this.dialogVisible=true;
                console.log()
            },
            //删除部门
            deleteDept(row){
                this.$confirm('是否确认删除名称为"' + row.deptName + '"的数据项?', "警告", {
                    confirmButtonText: "确定",
                    cancelButtonText: "取消",
                    type: "warning"
                }).then(function() {
                    return deleteDept(row.deptId);
                }).then(() => {
                    this.getList();
                    this.msgSuccess("删除成功");
                })
            },
            //编辑部门
            editDept(deptid){
                console.log(deptid)
                this.title="修改部门"
                selectDept(deptid).then(response=>{
                    console.log(response.data)
                    this.form = response.data;
                    this.dialogVisible = true;
                })
            },
            // 表单重置
            reset() {
                this.form = {
                    deptId: undefined,
                    parentId: undefined,
                    deptName: undefined,
                    orderNum: undefined,
                    leader: undefined,
                    phone: undefined,
                    email: undefined,
                    status: "0"
                };
            },
            // 表单取消按钮
            cancel(){
                this.dialogVisible = false;
                // console.log(this.form)
                this.reset()
            },
            //提交表单按钮
            submitForm(){
                console.log(this.form);
                if (this.form.deptId!=undefined){
                    updateDept(this.form).then(response=>{
                        console.log(response)
                        this.getList();
                        this.dialogVisible=false;
                    });
                    this.dialogVisible=false;
                }else{
                    addDept(this.form).then(response=>{
                        console.log(response)
                        this.getList();
                        this.dialogVisible=false;
                    })
                }

            }

        }
    }
</script>

<style scoped>

</style>
