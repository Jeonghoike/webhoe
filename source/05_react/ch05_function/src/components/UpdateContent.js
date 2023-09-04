const UpdateContent = props =>{
    return(
        <article>
            <h2>CREATE</h2>
            <form onSubmit={event => {
                            event.preventDefault();
                            props.onUpdate(
                                Number(event.target.id.value),
                                event.target.title.value, 
                                event.target.desc.value);
            }}>
                <p><input type="text" hidden name="id" defaultValue={props.data.id}/></p>
                <p><input type="text" name="title" defaultValue={props.data.title}/></p>
                <p><textarea name="desc" defaultValue={props.data.desc}></textarea></p>
                <p><input type="submit" value="수정" /></p>
            </form>
        </article>
    )
};
export default UpdateContent;