import './Subject.css';
const Subject = props => {
    return (
    <header className="subject">
        <h1 onClick={function(){
        props.onChangePage();
        }}>{props.title}</h1>
    </header>
    );
};
export default Subject;