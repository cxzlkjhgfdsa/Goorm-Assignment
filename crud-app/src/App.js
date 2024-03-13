import { useState } from "react";
import "./App.css";
import Alarm from "./components/Alarm";
import Form from "./components/Form";
import Lists from "./components/Lists";

function App() {
    const [budget, setBudget] = useState([]);
    const [update, setUpdate] = useState(false);
    const [total, setTotal] = useState(0);
    const [id, setId] = useState(0);
    const [state, setState] = useState(0);

    return (
        <div className="App">
            <div className="main-container">
                <Alarm state={state} />
                <h1>예산 계산기</h1>
                <div className="components">
                    <Form
                        budget={budget}
                        setBudget={setBudget}
                        update={update}
                        setState={setState}
                        setUpdate={setUpdate}
                        setTotal={setTotal}
                        id={id}
                    />
                    <Lists
                        budget={budget}
                        setBudget={setBudget}
                        setUpdate={setUpdate}
                        setState={setState}
                        setId={setId}
                        setTotal={setTotal}
                    />
                </div>
                <h2>총 지출 : {total}</h2>
            </div>
        </div>
    );
}

export default App;
