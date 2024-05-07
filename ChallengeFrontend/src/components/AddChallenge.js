import axios from "axios";
import { useState } from "react";

function AddChallenge({onChallengeAdded}){

    const [month,setMonth] = useState('');
    const [description,setDescription] = useState('');

    const handleSubmit = async(e) => {
        e.preventDefault();
        try {
            await axios.post('http://localhost:8080/challenges',{month, description});
            setMonth('');
            setDescription('');
            onChallengeAdded();
        } catch (error) {
            console.error("Error adding challenges: ", error);
        }
    };


    return(
        <div className="card my-5">
             <div className ="card-header">
                Add new challenge
            </div>
            <div className="card-body">
                <form onSubmit={handleSubmit}>
                    <div className="mb-3">
                        <label htmlFor="month" className="form-label">Month</label>
                        <select className="form-select" id="month" value={month} onChange={(e) => setMonth(e.target.value)} required>
                            <option value="">Selecciona un mes</option>
                            <option value="Enero">Enero</option>
                            <option value="Febrero">Febrero</option>
                            <option value="Marzo">Marzo</option>
                            <option value="Abril">Abril</option>
                            <option value="Mayo">Mayo</option>
                            <option value="Junio">Junio</option>
                            <option value="Julio">Julio</option>
                            <option value="Agosto">Agosto</option>
                            <option value="Septiembre">Septiembre</option>
                            <option value="Octubre">Octubre</option>
                            <option value="Noviembre">Noviembre</option>
                            <option value="Diciembre">Diciembre</option>
                        </select>
                    </div>
                    <div className="mb-3">
                        <label htmlFor="description" className="form-label">Description</label>
                        <textarea type="text" className="form-control" placeholder="Describe the challenge" id="description" value={description} onChange={(e) => setDescription(e.target.value)} required></textarea>
                    </div>
                    <button type="submit" className="btn btn-primary">Submit</button>
                </form>
            </div>
         </div>

    );

}

export default AddChallenge;