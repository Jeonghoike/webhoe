import './Control.css';
const Control = props =>{
    return (
        <ul className="control">
            <li>
                <button onClick={() => {
                    props.onChangeMode('create');
                }}>
                    CREATE
                </button>
            </li>
            <li>
                <button onClick={() => {
                    props.onChangeMode('update');
                }}>
                    UPDATE
                </button>
            </li>
            <li>
                <button onClick={() => {
                    props.onChangeMode('delete');
                }}>
                    DELETE
                </button>
            </li>
        </ul>
    );
};
export default Control;