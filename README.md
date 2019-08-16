# SpringBoot2.1.7整合Elasticsearch7.3.0
**项目说明** 
- 该项目采用SpringBoot，Elasticsearch进行整合开发学习。
- 该项目中的Elasticsearch整合了Elasticsearch-head 可视化工具，在项目中也自行下载Kibana官方可视化工具进行辅助操作。(注：下载Kibana的时必须保证Kibana的版本与Elasticsearch版本一致，由于本文中使用的是7.3.0版本，那么Kibana的也需要下载7.3.0版本，下载地址：https://www.elastic.co/cn/downloads/)
- 该项目只是对Elasticsearch 中的常用JavaApi进行演示，对数据进行索引和分析。

<br>

**技术选型：**
- 核心框架：SpringBoot2.1.7
- 搜索引擎：Elasticsearch7.3.0
- 简化代码：Lombok1.18+
- 阿里JSON转换：fastjson1.2.37
- 可视化页面：vue

<br>

 
**软件需求** 
- JDK：1.8
- Elasticsearch7.3.0
- Elasticsearch-head
- node8.0.0+

说明： 在没有使用Elasticsearch-head时，那么node环境和Vue无需掌握，可以直接使用官当的Kibana进行可视化操作。

<br>

**项目结构** 

```sh
SpringBoot-Elasticsearch
├─elasticsearch-head	可视化插件
│
├─springboot-es  SpringBoot整合Elasticsearch 核心模块
│	└─src	核心代码
│
│
│
│
```
<br>

**本地部署**
- 通过git下载源码
- idea、eclipse需安装lombok插件，不然会提示找不到entity的get set方法
- 启动Elasticsearch7.3.0服务，进入到Elasticsearch7.3.0的 bin目录中双击elasticsearch.bat（win系统），（mac系统通过elasticsearch启动）。
- 修改application.properties文件，更改连接Elasticsearch配置， 如果Elasticsearch部署在本地无需修改
- Eclipse、IDEA运行SpringbootEsApplication.java，则可启动项目【springboot-es】

<br>

- 如果需要启动可视化工具elasticsearch-head，需要安装node环境。
- 在启动elasticsearch-head之前需要配置Elasticsearch7.3.0环境，因为elasticsearch-head和Elasticsearch7.3.0是两个不同的服务，它们之间存在跨域问题。
- 找到下载好的Elasticsearch7.3.0\config\elasticsearch.yml 文件进行编辑在尾端追加以下配置，重新启动Elasticsearch7.3.0

```sh
http.cors.enabled: true
http.cors.allow-origin: "*"
```

- 启动elasticsearch-head 通过以下命令

```sh
cd elasticsearch-head
npm install
npm run start
```

<br>

- 如果需要使用Kibana，需要下载对应版本进行解压。
- 切换到kibana-7.3.0-windows-x86_64\bin目录中双击kibana.bat

<br>

- 访问项目地址：127.0.0.1:8066/需要访问的接口
- 访问elasticsearch-head可视化工具地址： http://localhost:9100/
- 访问kibana-7.3.0-windows-x86_64官方可视化工具地址：http://127.0.0.1:5601
- 直接访问Elasticsearch7.3.0服务地址：http://127.0.0.1:9200/

<br>

**补充说明**
- 在该创库中未上传Elasticsearch7.3.0和kibana-7.3.0-windows-x86_64服务，因为文件过大上传了会造成用户无法git到项目，可以自行在官方下载，下载时注意版本差异，
- 官方下载地址：https://www.elastic.co/cn/downloads/past-releases#kibana
- 注：下载时较慢因为文件比较大，当网络较差时下载有可能会中断。

**Email：1289010524@qq.com**

