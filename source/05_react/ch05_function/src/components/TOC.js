const TOC = props => {
    var lists = [];
    var data = props.data;
    for(var i=0 ; i<data.length ; i++){
        lists.push(<li key={data[i].id}>
                    <a href="/"
                        data-id={data[i].id}
                        id={data[i].id}
                        onClick={event => {
                            event.preventDefault(); // 본래 a태그의 기능을 막음
                            //props.onChangePage(event.target.dataset.id);
                            props.onChangePage(Number(event.target.id));
                        }}>
                        {data[i].title}
                    </a>
                    </li>);
    } // for
    return (
        <nav>
            <ol>
                {lists}
            </ol>
        </nav>
    );
};
export default TOC;