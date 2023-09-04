import { Component } from 'react';
class TOC extends Component{
    render(){
        var lists =[];
        var data = this.props.data;
        for(var i=0 ; i<data.length ; i++){
            lists.push(<li key={data[i].id}>
                            <a href={data[i].id+".html"}
                                // data-id={data[i].id}
                                onClick={function(id, e){
                                    e.preventDefault();
                                    // console.log(e.target.dataset.id, typeof(e.target.dataset.id));
                                    // this.props.onChangePage(e.target.dataset.id);
                                    this.props.onChangePage(id);
                                }.bind(this, data[i].id)}>
                                {data[i].title}
                            </a>
                        </li>);
        }
        console.log('TOC render 수행')
        return(
        <nav>
            <ul>
                {lists}
            </ul>
        </nav>
        );
    }
}
export default TOC