import { Component } from "react";

class CreateContent extends Component{
    render(){
        return(
            <article>
                <h2>CREATE</h2>
                <form onSubmit={function(e){ // e는 이벤트가 걸리게한 태그
                    e.preventDefault();
                    // console.log(e.target.title.value);
                    // console.log(e.target.desc.value);
                    // debugger;
                    this.props.onSubmitCreate(e.target.title.value, e.target.desc.value);
                    e.target.title.value = '';
                    e.target.desc.value = '';
                }.bind(this)}>
                    <p><input type="text" name="title" placeholder="title"/></p>
                    <p><textarea name="desc" placeholder="desc"></textarea></p>
                    <p><input type="submit" value="추가"/></p>
                </form>
            </article>
        );
    }
}
export default CreateContent;