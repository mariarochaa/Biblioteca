
export interface CodigoDewey {
  codigo?: string;
  classificacao?: string;
}


export interface ILivro extends CodigoDewey {
  id?: number;
  isbn: number;
  nome?: string;
  autor?: string;
  categoria?: string;
  codigodewey: string
  descricao: string;
  subtitulo: string;
  ano?: number;
  caminhoImagens: string;
  tema?: string;
  cd?: string;
  nomeCategoria?: string
}









