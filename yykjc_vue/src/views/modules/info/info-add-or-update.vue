<template>
  <el-dialog
    :title="!dataForm.id ? '发布信息' : '修改信息'"
    :close-on-click-modal="false"
    :visible.sync="visible">
    <el-form :model="dataForm" :rules="dataRule" ref="dataForm" @keyup.enter.native="dataFormSubmit()" label-width="80px">
    <!--<el-form-item label="用户id" prop="userId">
      <el-input v-model="dataForm.userId" placeholder="用户id"></el-input>
    </el-form-item>-->
    <el-form-item label="用户名" prop="userName">
      <el-input v-model="dataForm.userName" placeholder="用户名"></el-input>
    </el-form-item>
    <el-form-item label="信息类型" prop="type">
      <el-select v-model="dataForm.type" placeholder="信息类型">
        <el-option
          v-for="item in options"
          :key="item.value"
          :label="item.label"
          :value="item.value">
        </el-option>
      </el-select>
      <!--<el-input v-model="dataForm.type" placeholder="信息类型"></el-input>-->
    </el-form-item>
    <!--<el-form-item label="" prop="createTime">
      <el-input v-model="dataForm.createTime" placeholder=""></el-input>
    </el-form-item>-->
    <!--<el-form-item label="" prop="views">
      <el-input v-model="dataForm.views" placeholder=""></el-input>
    </el-form-item>-->
    <el-form-item label="标题" prop="title">
      <el-input v-model="dataForm.title" placeholder="标题"></el-input>
    </el-form-item>
    <el-form-item label="描述" prop="describe">
      <el-input
        type="textarea"
        :rows="3"
        placeholder="描述"
        v-model="dataForm.describe">
      </el-input>
      <!--<el-input v-model="dataForm.describe" placeholder="描述"></el-input>-->
    </el-form-item>
    <!--<el-form-item label="" prop="status">
      <el-input v-model="dataForm.status" placeholder=""></el-input>
    </el-form-item>-->
    </el-form>
    <span slot="footer" class="dialog-footer">
      <el-button @click="visible = false">取消</el-button>
      <el-button type="primary" @click="dataFormSubmit()">发布</el-button>
    </span>
  </el-dialog>
</template>

<script>
  export default {
    data () {
      return {
        visible: false,
        options: [{
          value: '失物招领',
          label: '失物招领'
        }, {
          value: '学院通知',
          label: '学院通知'
        }, {
          value: '表白墙',
          label: '表白墙'
        }, {
          value: '活动中心',
          label: '活动中心'
        }],
        value: '',
        dataForm: {
          id: 0,
          userId: '',
          userName: '',
          type: '',
          createTime: '',
          views: '',
          title: '',
          describe: '',
          status: ''
        },
        dataRule: {
          userId: [
            { required: true, message: '用户id不能为空', trigger: 'blur' }
          ],
          userName: [
            { required: true, message: '用户名不能为空', trigger: 'blur' }
          ],
          type: [
            { required: true, message: '信息类型 1 失物招领，2 学院通知，3 表白墙不能为空', trigger: 'blur' }
          ],
          createTime: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          views: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          title: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          describe: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ],
          status: [
            { required: true, message: '不能为空', trigger: 'blur' }
          ]
        }
      }
    },
    methods: {
      init (id) {
        this.dataForm.id = id || 0
        this.visible = true
        this.$nextTick(() => {
          this.$refs['dataForm'].resetFields()
          if (this.dataForm.id) {
            this.$http({
              url: this.$http.adornUrl(`/info/info/info/${this.dataForm.id}`),
              method: 'get',
              params: this.$http.adornParams()
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.dataForm.userId = data.info.userId
                this.dataForm.userName = data.info.userName
                this.dataForm.type = data.info.type
                this.dataForm.createTime = data.info.createTime
                this.dataForm.views = data.info.views
                this.dataForm.title = data.info.title
                this.dataForm.describe = data.info.describe
                this.dataForm.status = data.info.status
              }
            })
          }
        })
      },
      // 表单提交
      dataFormSubmit () {
        this.$refs['dataForm'].validate((valid) => {
          if (valid) {
            this.$http({
              url: this.$http.adornUrl(`/info/info/${!this.dataForm.id ? 'save' : 'update'}`),
              method: 'post',
              data: this.$http.adornData({
                'id': this.dataForm.id || undefined,
                'userId': this.dataForm.userId,
                'userName': this.dataForm.userName,
                'type': this.dataForm.type,
                'createTime': this.dataForm.createTime,
                'views': this.dataForm.views,
                'title': this.dataForm.title,
                'describe': this.dataForm.describe,
                'status': this.dataForm.status
              })
            }).then(({data}) => {
              if (data && data.code === 0) {
                this.$message({
                  message: '操作成功',
                  type: 'success',
                  duration: 1500,
                  onClose: () => {
                    this.visible = false
                    this.$emit('refreshDataList')
                  }
                })
              } else {
                this.$message.error(data.msg)
              }
            })
          }
        })
      }
    }
  }
</script>
