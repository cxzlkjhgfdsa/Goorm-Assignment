import React from "react";
import List from "./List";
import "./Lists.css";
import { FaTrash } from "react-icons/fa";

const Lists = ({ budget, setBudget, setUpdate, setTotal, setId, setState }) => {
    const handleRemoveAll = () => {
        setBudget([]);
        setTotal(0);
    };

    return (
        <div>
            {budget.map((data) => (
                <List
                    key={data.id}
                    id={data.id}
                    title={data.title}
                    price={data.price}
                    budget={budget}
                    setBudget={setBudget}
                    setTotal={setTotal}
                    setUpdate={setUpdate}
                    setId={setId}
                    setState={setState}
                />
            ))}
            <button className="removeAll-btn" onClick={handleRemoveAll}>
                <span>목록지우기</span> <FaTrash color="white" />
            </button>
        </div>
    );
};

export default Lists;
