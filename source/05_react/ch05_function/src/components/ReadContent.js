const ReadContent = props => {
    return (
        <article>
            <h2>{props.title}</h2>
            {props.desc}
        </article>
    );
};
export default ReadContent;