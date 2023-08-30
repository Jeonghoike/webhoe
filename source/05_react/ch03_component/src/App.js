import './App.css';
import { Component } from 'react';

class App extends Component{
  render(){
    return( // 리턴안에 완벽하게 감싸져있는 태그 필요
      <div>
        Hello,React!!
        <Subject></Subject>
      </div>
    );
  }
}
class Subject extends Component{
  render(){
    return(
      <header>
        <h1>Web</h1>
        World Wide Web!
    </header>
    );
  }
}
export default App;
