# jxx  校园资讯平台
贾霄霄毕业设计-校园咨询平台

# 如何下载该源码
- 首先下载git工具 下载地址:https://git-scm.com/
- 然后安装git工具
- 在本地新建一个文件夹，作为git的仓库 文件名随意
- 进入新建好的文件夹，右击选择 git bash here ，打开git命令窗口
- 在git命令窗口中输入命令:  git clone https://github.com/zhuangsuzheng/xyzxpt.git
- 等待数据抓取完毕，这样就会将校园资讯平台的所有源码都抓取到本地了

# 官方教程
…or create a new repository on the command line
echo "# xyzxpt" >> README.md
git init
git add README.md
git commit -m "first commit"
git remote add origin https://github.com/zhuangsuzheng/xyzxpt.git
git push -u origin master
                
…or push an existing repository from the command line
git remote add origin https://github.com/zhuangsuzheng/xyzxpt.git
git push -u origin master
…or import code from another repository
You can initialize this repository with code from a Subversion, Mercurial, or TFS project.

# 仓库介绍
- 仓库内系统为校园资讯平台  仓库内是整个系统的代码(前后端)
- 

# vue项目启动

第一步 安装:

- 命令: npm install chromedriver --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver

第二步 运行

- 命令: npm run dev

可能遇到的问题:

刚开始以为是 node 或 npm 版本问题，前前后后折腾了好久，终于解决了

如果执行过npm install，先删除 node_modules 文件夹，不然运行的时候可能会报错

执行下面的命令

npm install chromedriver --chromedriver_cdnurl=http://cdn.npm.taobao.org/dist/chromedriver

再执行 npm install 即可正常下载

经分析发现，某些版本下，chromedriver 的 zip 文件 url 的响应是 302 跳转，而在 install.js 里使用的是 Node.js 内置的 http 对象的 get 方法无法处理 302 跳转的情况；而在另外一些情况下，则是因为 googleapis.com 被墙了，此时即使采用科学 上网的方法也仍然无法获取文件。
