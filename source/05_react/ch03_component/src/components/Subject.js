import { Component } from 'react';
import './Subject.css';
class Subject extends Component{
    render(){
        console.log('Subject render 수행')
        return(
        <header>
            <h1>
                <a href='/' onClick={function(e){
                    e.preventDefault();
                    this.props.onChangePage();
                }.bind(this)}>
                    {this.props.title}
                </a>
            </h1>
            {this.props.sub}
        </header>
        );
    }
}
export default Subject; // 외부에서 실행하기위해 필요