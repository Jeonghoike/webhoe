const express = require('express'); // express 라이브러를 첨부
const app = express(); // express 라이브러리를 이용한 객체 생성

const url = "mongodb+srv://yisy0703:R2r1S8H3eInrqluq@cluster0.6mnuke9.mongodb.net/?retryWrites=true&w=majority";
const MongoClient = require('mongodb').MongoClient;
var db;
MongoClient.connect(url, function(err, client){
  // 몽고DB 연결 후 실행할 콜백함수
  if(err){return console.log(err);}
  db = client.db('toDoApp');
  //app.listen(서버를 띄울 포트번호, 서버연동후 실행할 콜백 함수)
  app.listen(8090, function(){
    console.log('listening on 8090');
  });
});

// app.get(요청경로, 요청이 들어올 경우 실행할 콜백함수)
// app.post(요청경로, 요청이 들어올 경우 실행할 콜백함수)
// app.put(요청경로, 요청이 들어올 경우 실행할 콜백함수)
// app.delete(요청경로, 요청이 들어올 경우 실행할 콜백함수)
app.use(express.static('public'));
app.set('view engine', 'ejs');
app.get('/', function(req, res){
  //res.sendFile(__dirname + '/index.html');
  res.render('index.ejs');
});

app.get('/write', (req, res)=>{
  //res.sendFile(__dirname + '/write.html');
  res.render('write.ejs');
});
app.use(express.urlencoded({extended:true})); // 넘어온 파라미터 접근하기
app.post('/write', (req, res)=>{
  // 1. counter에서 post_sq를 가져옴
  db.collection('counter').findOne({name : '현재시퀀스'}, function(err, result){
    if(err) {return console.log(err);}
    // console.log(result);
    var post_sq = result.post_sq;
    // 2. {_id:post_sq+1, title:req.body.title, date:req.body.date} 를 post에 insert
    db.collection('post').insertOne({_id: post_sq+1,
                                    title: req.body.title,
                                    date : req.body.date}, function(err, result){
      if(err) {return console.log(err);}
      // 3. counter의 post_sq를 1증가  
      // updateOne({조건}, {수정내용}, 콜백함수)
      // updateOne({조건}, {$inc : {증가분}}, 콜백함수)
      // updateOne({조건}, {$set : {수정내용}}, 콜백함수)
      db.collection('counter').updateOne({name:'현재시퀀스'},
                                      // {$int : {post_sq: 1}},
                                         {$set : {post_sq: post_sq+1}},
                                         function(err, result){
            if(err) {return console.log(err);}
            res.redirect('/list');
      }); // 3
    });  // 2  
  }); // 1   
});
app.get('/list', (req, res)=>{
  // post에서 저장된 데이터(배열)로 view단(ejs)으로 출력
  db.collection('post').find().toArray(function(err, result){
    if(err){return console.log(err);}
    res.render('list.ejs', {posts:result});
  });
});

app.delete('/delete', (req, res)=>{
  // _id파라미터 값(string)의 _id(int32)인 post를 삭제한다
  var _id = Number(req.body._id); // 삭제할 _id
  // console.log(_id, typeof(_id));
  db.collection('post').deleteOne({_id : _id}, function(err, result){
    if(err) {return console.log(err);}
    console.log(_id, '번 post 삭제 완료');
    res.status(200).send({msg : _id+'번 post 삭제 완료했습니다'});
  });
})

app.get('/detail/:id', (req, res)=>{
  var id = parseInt(req.params.id);
  db.collection('post').findOne({_id : id}, function(err, result){
    if(err) {return console.log(err);}
    //console.log(result);
    res.render('detail.ejs', {post:result});
  });
});

app.get('/update/:id', (req, res)=>{
  var id = Number(req.params.id);
  db.collection('post').findOne({_id:id}, function(err, result){
    if(err) {return console.log(err);}
    res.render('update.ejs', {post : result});
  });
});

app.post('/update', (req, res)=>{
  console.log('수정내용 :', req.body); // {_id:'2', title:'노드', date:'2023-12-12'}
  let _id = Number(req.body._id);
  // updateOne({조건}, {$set : {수정내용}}, 콜백함수)
  db.collection('post').updateOne({_id:_id},
              {$set : {title:req.body.title,
                        date: req.body.date}},
              (err, result)=>{
                  if(err) {return console.log(err);}            
                  res.redirect('/detail/'+_id);
  });
});

app.put('/update', (req, res)=>{
  let _id = parseInt(req.body._id); // '3'
  db.collection('post').updateOne({_id:_id},
    {$set : {title:req.body.title, date : req.body.date}},
    (err, result)=>{
      if(err) {return console.log(err);}
      res.status(200).send({msg : _id+'번째 post 수정완료했습니다'});
    });
});