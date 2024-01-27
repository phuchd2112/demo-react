import axios from "axios";
import "./App.css";
import api from "./api/axiosConfig";
import { useState, useEffect } from "react";
import Layout from "./component/layout";
import { Route, Routes } from "react-router-dom";
import Home from "./component/home/Home";
import Header from "./component/header/Header";
import Trailer from "./component/trailer/Trailer";
import Reviews from "./component/reviews/Reviews";

function App() {
  const [movies, setMovies] = useState();
  const [movie, setMovie] = useState();
  const [reviews, setReviews] = useState([]);
  
  const getMovie = async () => {
    try {
      const response = await axios.get("/api/v1/movies");
      console.log(response.data);
      setMovies(response.data);
    } catch (err) {
      console.log(err);
    }
  };

  const getMovieData = async (movieId) => {
    try {
      const response = await axios.get(`/api/v1/movies/imdb/${movieId}`);
      const singleMovie = response.data;
      setMovie(singleMovie);
    } catch (error) {
      console.log(error);
    }
  }

  useEffect(() => {
    getMovie();
  }, []);

  return <div className="App">
    <Header />
    <Routes>
      <Route path="/" element={<Layout/>}>
      <Route path="/" element={<Home movies={movies}/>}></Route>
      <Route path="/Trailer/:ytTrailerId" element={<Trailer/>}></Route>
      <Route path="/Reviews/:movieId" element={<Reviews getMovieData={getMovieData} movie={movie} reviews={reviews} setReviews={setReviews}/>}></Route>
      </Route>
    </Routes>
  </div>;
}

export default App;
