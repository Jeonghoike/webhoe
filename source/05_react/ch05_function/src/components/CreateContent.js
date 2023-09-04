const CreateContent = props =>{
    return(
        <article>
            <h2>CREATE</h2>
            <form onSubmit={event => {
                            event.preventDefault();
                            props.onCreate(event.target.title.value, event.target.desc.value);
            }}>
                <p><input type="text" name="title" placeholder="title" /></p>
                <p><textarea name="desc" placeholder="desc"></textarea></p>
                <p><input type="submit" value="추가" /></p>
            </form>
        </article>
    );
};
export default CreateContent;