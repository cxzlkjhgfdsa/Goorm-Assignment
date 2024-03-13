import React from "react";
import { BsFillPencilFill } from "react-icons/bs";
import { FaTrash } from "react-icons/fa";
import "./List.css";

const List = ({ budget, setBudget, setTotal, setId, setUpdate, title, price, id, setState }) => {
    const handleRemove = () => {
        let newList = budget.filter((data) => data.id !== id);
        setBudget(newList);
        setTotal((prev) => parseInt(prev) - parseInt(price));
        setState(3);
    };
    const handleClick = () => {
        setId(id);
        setUpdate(true);
    };

    return (
        <div className="list-container">
            <div className="items-container">
                <div className="items-name">
                    <span>{title}</span>
                </div>
                <div className="items-cost">
                    <span>{price}</span>
                </div>
                <div className="items-controller">
                    <button onClick={handleClick}>
                        <BsFillPencilFill color="green" font-size="1.3rem" />
                    </button>{" "}
                    <button onClick={handleRemove}>
                        <FaTrash color="darkred" font-size="1.3rem" />
                    </button>
                </div>
            </div>
        </div>
    );
};

export default List;
