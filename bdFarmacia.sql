-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: 22-Nov-2019 às 13:56
-- Versão do servidor: 10.1.26-MariaDB
-- PHP Version: 7.0.23

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `bdfarmacia`
--

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbcliente`
--

CREATE TABLE `tbcliente` (
  `idCliente` int(11) NOT NULL,
  `nomeCliente` varchar(255) NOT NULL,
  `cpfCliente` varchar(11) NOT NULL,
  `rgCliente` varchar(15) NOT NULL,
  `logradouroCliente` varchar(255) NOT NULL,
  `numCliente` int(11) NOT NULL,
  `complCliente` varchar(32) NOT NULL,
  `bairroCliente` varchar(64) NOT NULL,
  `cidadeCliente` varchar(128) NOT NULL,
  `cepCliente` varchar(8) NOT NULL,
  `ufCliente` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfornecedor`
--

CREATE TABLE `tbfornecedor` (
  `idFornecedor` int(11) NOT NULL,
  `nomeFornecedor` varchar(255) NOT NULL,
  `cnpjFornecedor` varchar(14) NOT NULL,
  `endFornecedor` varchar(50) NOT NULL,
  `telFornecedor` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfuncionario`
--

CREATE TABLE `tbfuncionario` (
  `idFuncionario` int(11) NOT NULL,
  `nomeFuncionario` varchar(255) NOT NULL,
  `cpfFuncionario` varchar(11) NOT NULL,
  `rgFuncionario` varchar(11) NOT NULL,
  `contaBancoFuncionario` varchar(8) NOT NULL,
  `agenciaFuncionario` varchar(6) NOT NULL,
  `nomeBancoFuncionario` varchar(20) NOT NULL,
  `logradouroFuncionario` varchar(255) NOT NULL,
  `numFuncionario` int(11) NOT NULL,
  `complFuncionario` varchar(32) NOT NULL,
  `bairroFuncionario` varchar(64) NOT NULL,
  `cidadeFuncionario` varchar(128) NOT NULL,
  `cepFuncionario` varchar(8) NOT NULL,
  `ufFuncionario` varchar(2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbitemvenda`
--

CREATE TABLE `tbitemvenda` (
  `codigoItemVenda` int(11) NOT NULL,
  `codigoProdutoItemVenda` int(11) NOT NULL,
  `quantidadeItemVenda` int(11) NOT NULL,
  `codigoVendaItemVenda` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbprodutos`
--

CREATE TABLE `tbprodutos` (
  `idProdutos` int(11) NOT NULL,
  `nomeProdutos` varchar(255) NOT NULL,
  `descricaoProdutos` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbtelefonecliente`
--

CREATE TABLE `tbtelefonecliente` (
  `idTelefoneCliente` int(11) NOT NULL,
  `nomeTelefoneCliente` varchar(255) NOT NULL,
  `TelefoneCliente` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbtelefonefornecedor`
--

CREATE TABLE `tbtelefonefornecedor` (
  `idTelefoneFornecedor` int(11) NOT NULL,
  `nomeTelefoneFornecedor` varchar(255) NOT NULL,
  `TelefoneFornecedor` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbtelefonefuncionario`
--

CREATE TABLE `tbtelefonefuncionario` (
  `idTelefoneFuncionario` int(11) NOT NULL,
  `nomeTelefoneFuncionario` varchar(255) NOT NULL,
  `TelefoneFuncionario` varchar(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbvenda`
--

CREATE TABLE `tbvenda` (
  `codigoVenda` int(11) NOT NULL,
  `funcionarioVenda` int(11) NOT NULL,
  `clienteVenda` int(11) NOT NULL,
  `valortotalVenda` decimal(10,2) NOT NULL,
  `dataVenda` timestamp NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Indexes for dumped tables
--

--
-- Indexes for table `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Indexes for table `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  ADD PRIMARY KEY (`idFornecedor`);

--
-- Indexes for table `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Indexes for table `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  ADD PRIMARY KEY (`codigoItemVenda`);

--
-- Indexes for table `tbprodutos`
--
ALTER TABLE `tbprodutos`
  ADD PRIMARY KEY (`idProdutos`);

--
-- Indexes for table `tbtelefonecliente`
--
ALTER TABLE `tbtelefonecliente`
  ADD PRIMARY KEY (`idTelefoneCliente`);

--
-- Indexes for table `tbtelefonefornecedor`
--
ALTER TABLE `tbtelefonefornecedor`
  ADD PRIMARY KEY (`idTelefoneFornecedor`);

--
-- Indexes for table `tbtelefonefuncionario`
--
ALTER TABLE `tbtelefonefuncionario`
  ADD PRIMARY KEY (`idTelefoneFuncionario`);

--
-- Indexes for table `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD PRIMARY KEY (`codigoVenda`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbfornecedor`
--
ALTER TABLE `tbfornecedor`
  MODIFY `idFornecedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbitemvenda`
--
ALTER TABLE `tbitemvenda`
  MODIFY `codigoItemVenda` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbprodutos`
--
ALTER TABLE `tbprodutos`
  MODIFY `idProdutos` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbtelefonecliente`
--
ALTER TABLE `tbtelefonecliente`
  MODIFY `idTelefoneCliente` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbtelefonefornecedor`
--
ALTER TABLE `tbtelefonefornecedor`
  MODIFY `idTelefoneFornecedor` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbtelefonefuncionario`
--
ALTER TABLE `tbtelefonefuncionario`
  MODIFY `idTelefoneFuncionario` int(11) NOT NULL AUTO_INCREMENT;

--
-- AUTO_INCREMENT for table `tbvenda`
--
ALTER TABLE `tbvenda`
  MODIFY `codigoVenda` int(11) NOT NULL AUTO_INCREMENT;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
