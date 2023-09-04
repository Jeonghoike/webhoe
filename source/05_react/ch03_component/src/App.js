import './App.css';
import { Component } from 'react';
import Subject from './components/Subject';
import TOC from './components/TOC';
import ReadContent from './components/ReadContent'; 
class App extends Component{
  constructor(props){
    super(props);
    this.state = {
      mode : 'read',
      selected_content_id : 2,
      subject : {title:'WEB', sub:"World Wide Web!"},
      contents : [
        {id:1, title:'HTML', desc:'HTML is HyperText Markup Language'},
        {id:2, title:'CSS', desc:'CSS is for Design'},
        {id:3, title:'JavaScript', desc:'JavaScript is for Interactive'},
        {id:4, title:'React', desc:'React is for UI'}
      ],
      welcome : {title:'Welcome', desc:'Hello, React!'},
    };
  }
  render(){
    console.log('App renfer 수행');
    var _title, _desc, _article = null;
    if(this.state.mode === 'welcome'){
      _title = this.state.welcome.title;
      _desc = this.state.welcome.desc;
      _article =<ReadContent title={_title} desc={_desc}></ReadContent>;
    }else if(this.state.mode === 'read'){
      // var data = this.state.contents[this.state.selected_content_id - 1];
      // _title = data.title;
      // _desc = data.desc;
      for(var i=0 ; i<this.state.contents.length ; i++){
        var data = this.state.contents[i];
        if(data.id === this.state.selected_content_id){
          _title = data.title;
          _desc = data.desc;
          break;
        }//if
      }//for
      _article = <ReadContent title={_title} desc={_desc}></ReadContent>;
    }else if(this.state.mode === 'create'){
      // _article = <createContent></createContent>;
    }else if(this.state.mode === 'update'){
      //_article = <UpdateContent></UpdateContent>;
    }
    return( // 리턴안에 완벽하게 감싸져있는 태그 필요
      <div>
        <Subject title={this.state.subject.title} 
                  sub={this.state.subject.sub} 
                  onChangePage={function(){
                    this.setState({
                      mode:'welcome'
                    });
                  }.bind(this)}></Subject>
        {/* <header>
            <h1>
                <a href='/' onClick={function(e){ // e클릭을 했을떄 태그 객체
                  e.preventDefault(); // 태그의 기본동작방법 막음
                  // this.state.mode를 'welcome으로
                  // this.state.mode = 'welcome'; state값을 변경하려면 setState()함수 이용
                  this.setState({
                    mode : 'welcome'
                  });
                  // console.log(this);
                  // debugger;
                }.bind(this)}>
                    {this.state.subject.title}
                </a>
            </h1>
            {this.state.subject.sub}
        </header> */}
        <TOC data={this.state.contents}
          onChangePage={function(id){
            this.setState({
              mode : 'read',
              selected_content_id : Number(id),
            });
          }.bind(this)}></TOC>
        {_article}
      </div>
    );
  }
}
export default App;
