import React, { useState } from "react";
import "./Form.css";
import { HiPaperAirplane } from "react-icons/hi";

const Form = ({ budget, setBudget, update, setTotal, id, setUpdate, setState }) => {
    const [title, setTitle] = useState("");
    const [price, setPrice] = useState(0);

    const handlePriceChange = (e) => {
        setPrice(e.target.value);
    };

    const handleTitleChange = (e) => {
        setTitle(e.target.value);
    };

    const hanldeCreateSubmit = (e) => {
        e.preventDefault();

        const newItem = {
            id: Date.now(),
            title: title,
            price: price,
        };

        setBudget((prev) => [...prev, newItem]);
        setTitle("");
        setTotal((prev) => parseInt(prev) + parseInt(price));
        setPrice(0);
        setState(1);
    };

    const handleUpdateSubmit = (e) => {
        e.preventDefault();

        let prevPrice = 0;

        const updateItem = budget.map((data) => {
            if (data.id === id) {
                prevPrice = data.price;
                data.title = title;
                data.price = price;
            }
            return data;
        });

        setTotal((prev) => parseInt(prev) - parseInt(prevPrice) + parseInt(price));
        setBudget(updateItem);
        setUpdate(false);
        setPrice(0);
        setTitle("");
        setState(2);
    };

    return (
        <form
            className="form=container"
            onSubmit={update ? handleUpdateSubmit : hanldeCreateSubmit}
        >
            <div className="form-main-container">
                <div className="input-div">
                    <p>지출 항목</p>
                    <input
                        type="text"
                        name="title"
                        value={title}
                        placeholder="예) 렌트비"
                        onChange={handleTitleChange}
                    />
                </div>
                <div className="input-div">
                    <p>지출 항목</p>
                    <input type="number" name="price" value={price} onChange={handlePriceChange} />
                </div>
            </div>
            {update ? (
                <button type="submit">
                    <span> 수정</span>
                    <HiPaperAirplane color="white" />
                </button>
            ) : (
                <button type="submit">
                    <span> 제출</span>
                    <HiPaperAirplane color="white" />
                </button>
            )}
        </form>
    );
};

export default Form;
