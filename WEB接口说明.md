## WEB接口

路径：**/ws （需认证）**

- 例子中的JSESSIONID是认证成功后获取的服务端SESSIONID，保存在Cookie


### 用户相关

####  获取当前登陆用户信息

路径：**/user/current**

说明：

- 参数：无
- Methon：**GET**
- Content-Type：**application/json**
- 返回值：

```
{"username":"admin","roles":["admin"],"attributes":{"phone":"11111111","email":"admin@test.com"}}
```

- 例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" http://127.0.0.1:8080/ws/user/current
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /ws/user/current HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> 
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 05:49:24 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Type: application/json
< Content-Length: 97
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
{"username":"admin","roles":["admin"],"attributes":{"phone":"11111111","email":"admin@test.com"}}
```

#### 获取所有用户信息

路径：**/user**

说明：

- 参数：无
- Methon：**GET**
- Content-Type：**application/json**
- 返回值：

```
[{"username":"admin","roles":["admin"],"attributes":{"phone":"11111111","email":"admin@test.com"}},{"username":"test","roles":["user"],"attributes":{"email":"test@test.com"}}]
```

- 例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" http://127.0.0.1:8080/ws/user
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /ws/user HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> 
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 05:54:25 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Type: application/json
< Content-Length: 175
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
[{"username":"admin","roles":["admin"],"attributes":{"phone":"11111111","email":"admin@test.com"}},{"username":"test","roles":["user"],"attributes":{"email":"test@test.com"}}]
```

#### 更新用户密码

路径：**/user/password**

说明：

- 参数：username, oldPassword, newPassword
- 密码采用**MD5**加密
- Methon：**POST**
- Content-Type：**application/x-www-form-urlencoded**
- 返回值：无
- 例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" http://127.0.0.1:8080/ws/user/password -d "username=admin&oldPassword=21232f297a57a5a743894a0e4a801fc3&newPassword=21232f297a57a5a743894a0e4a801fc3"
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /ws/user/password HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> Content-Length: 104
> Content-Type: application/x-www-form-urlencoded
> 
* upload completely sent off: 104 out of 104 bytes
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 06:03:33 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Length: 0
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
```

### 烟草信息相关

#### 获取所有烟草信息及库存状态

路径：**/tobacco**

说明：

- 参数：无
- Methon：**GET**
- Content-Type：**application/json**
-  返回值：

```
[{"id":"0D1FDD6C270D437E80DBC7C796FC7ABB","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create2","updated":1496764800000,"quantity":2000,"status":1},{"id":"1AA9BC4AC2294C798EF60FB11E23C56D","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create","updated":1496764800000,"quantity":2000,"status":1},{"id":"1EC9B22ED37C445C8A3D21CF106EF264","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create4","updated":1496764800000,"quantity":2000,"status":1},{"id":"FD1F774749BD4835BBF12A3349BC734E","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update2","updated":1496851200000,"quantity":2000,"status":1}]
```

- 例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" http://127.0.0.1:8080/ws/tobacco
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /ws/tobacco HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> 
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 06:11:04 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Type: application/json
< Content-Length: 796
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
[{"id":"0D1FDD6C270D437E80DBC7C796FC7ABB","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create2","updated":1496764800000,"quantity":2000,"status":1},{"id":"1AA9BC4AC2294C798EF60FB11E23C56D","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create","updated":1496764800000,"quantity":2000,"status":1},{"id":"1EC9B22ED37C445C8A3D21CF106EF264","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create4","updated":1496764800000,"quantity":2000,"status":1},{"id":"FD1F774749BD4835BBF12A3349BC734E","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update2","updated":1496851200000,"quantity":2000,"status":1}]
```

#### 创建烟草信息及库存状态

路径：**/tobacco**

说明：

- 参数：

```
{"name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create","quantity":2000,"status":1}
```

- Methon：**POST**
- Content-Type：**application/json**
-  返回值：无
-  例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" -H "Content-Type:application/json" http://127.0.0.1:8080/ws/tobacco  -d '{"name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test create","quantity":2000,"status":1}'
* Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /ws/tobacco HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> Content-Type:application/json
> Content-Length: 133
> 
* upload completely sent off: 133 out of 133 bytes
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 06:23:19 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Length: 0
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
```

#### 更新烟草信息及库存状态

路径：**/tobacco**

说明：

- 参数：

```
{"id":"C09159FE910941299A9DAD5CE9FA59E0","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update","updated":1496851200000,"quantity":2000,"status":1}
```

- Methon：**PUT**
- Content-Type：**application/json**
-  返回值：更新后的对象
-  例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" -H "Content-Type:application/json" http://127.0.0.1:8080/ws/tobacco -X PUT -d '{"id":"C09159FE910941299A9DAD5CE9FA59E0","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update","updated":1496851200000,"quantity":2000,"status":1}'
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> PUT /ws/tobacco HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> Content-Type:application/json
> Content-Length: 197
> 
* upload completely sent off: 197 out of 197 bytes
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 06:26:57 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Type: application/json
< Content-Length: 197
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
{"id":"C09159FE910941299A9DAD5CE9FA59E0","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update","updated":1496851200000,"quantity":2000,"status":1}
```

#### 删除烟草信息及库存状态

路径：**/tobacco**

说明：

- 参数：

```
{"id":"C09159FE910941299A9DAD5CE9FA59E0","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update","updated":1496851200000,"quantity":2000,"status":1}
```

- Methon：**DELETE**
- Content-Type：**application/json**
-  返回值：无
-  例子：

```
curl -v -H "Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n" -H "Content-Type:application/json" http://127.0.0.1:8080/ws/tobacco -X DELETE -d '{"id":"C09159FE910941299A9DAD5CE9FA59E0","name":"黄鹤楼","mfrs":"云南卷烟厂","spec":"xx","price":18.8,"description":"This is test update","updated":1496851200000,"quantity":2000,"status":1}''
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> DELETE /ws/tobacco HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=1457adma9y2dw2cet8nv9lr2n
> Content-Type:application/json
> Content-Length: 197
> 
* upload completely sent off: 197 out of 197 bytes
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 06:29:36 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Length: 0
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
```

### 订单相关

####  获取当前用户所有订单信息

路径：**/order**

说明：

- 参数：?username=xxx&status=xxx
username：当前登录用户名，**必须提供**；status：订单状态（1 已处理，0 未处理）如果不提供status则默认所有状态订单
- Methon：**GET**
- Content-Type：**application/json**
- 返回值：

```
curl -v -H "Cookie:JSESSIONID=17q6vhzsi83r0swxjz41gqjuc" http://127.0.0.1:8080/ws/order?username=admin
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> GET /ws/order?username=admin HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=17q6vhzsi83r0swxjz41gqjuc
> 
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 07:16:27 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Type: application/json
< Content-Length: 170
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
[{"id":"E4020B769DA1491EA617898D14E323BD","username":"admin","tobaccoId":"1AA9BC4AC2294C798EF60FB11E23C56D","quantity":3,"money":5.64,"status":1,"updated":1496851200000}]
```

####  创建订单信息

路径：**/order**

说明：

- 参数：

```
{"username":"admin","tobaccoId":"1AA9BC4AC2294C798EF60FB11E23C56D","quantity":3,"money":5.64,"status":0}
```
- Methon：**POST**
- Content-Type：**application/json**
- 返回值：无
- 例子：

```
curl -v -H "Cookie:JSESSIONID=17q6vhzsi83r0swxjz41gqjuc" -H "Content-Type:application/json" http://127.0.0.1:8080/ws/order -d '{"username":"admin","tobaccoId":"1AA9BC4AC2294C798EF60FB11E23C56D","quantity":3,"money":5.64,"status":0}'
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> POST /ws/order HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=17q6vhzsi83r0swxjz41gqjuc
> Content-Type:application/json
> Content-Length: 104
> 
* upload completely sent off: 104 out of 104 bytes
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 07:19:24 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Length: 0
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
```

####  更新订单状态

路径：**/order**

说明：

- 参数：

```
{"id":"46B5AAE88CE54E6CBC389EB9EB273B4C","username":"admin","tobaccoId":"1AA9BC4AC2294C798EF60FB11E23C56D","quantity":3,"money":5.64,"status":0,"updated":1496851200000}
```
- Methon：**PUT**
- Content-Type：**application/json**
- 返回值：无
- 例子：

```
curl -v -H "Cookie:JSESSIONID=17q6vhzsi83r0swxjz41gqjuc" -H "Content-Type:application/json" -X PUT http://127.0.0.1:8080/ws/order -d '{"id":"46B5AAE88CE54E6CBC389EB9EB273B4C","username":"admin","tobaccoId":"1AA9BC4AC2294C798EF60FB11E23C56D","quantity":3,"money":5.64,"status":1,"updated":1496851200000}'
*   Trying 127.0.0.1...
* TCP_NODELAY set
* Connected to 127.0.0.1 (127.0.0.1) port 8080 (#0)
> PUT /ws/order HTTP/1.1
> Host: 127.0.0.1:8080
> User-Agent: curl/7.51.0
> Accept: */*
> Cookie:JSESSIONID=17q6vhzsi83r0swxjz41gqjuc
> Content-Type:application/json
> Content-Length: 168
> 
* upload completely sent off: 168 out of 168 bytes
< HTTP/1.1 200 OK
< Date: Thu, 08 Jun 2017 07:22:10 GMT
< Cache-Control: no-cache, no-store, max-age=0, must-revalidate
< Pragma: no-cache
< Expires: 0
< X-XSS-Protection: 1; mode=block
< X-Frame-Options: SAMEORIGIN
< X-Content-Type-Options: nosniff
< Content-Length: 0
< 
* Curl_http_done: called premature == 0
* Connection #0 to host 127.0.0.1 left intact
```