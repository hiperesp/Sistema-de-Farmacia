-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Tempo de geração: 05-Dez-2019 às 01:18
-- Versão do servidor: 10.4.6-MariaDB
-- versão do PHP: 7.3.9

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Banco de dados: `bdfarmacia`
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

--
-- Extraindo dados da tabela `tbcliente`
--

INSERT INTO `tbcliente` (`idCliente`, `nomeCliente`, `cpfCliente`, `rgCliente`, `logradouroCliente`, `numCliente`, `complCliente`, `bairroCliente`, `cidadeCliente`, `cepCliente`, `ufCliente`) VALUES
(74, 'Irineu Da Silva', '12345678910', '121231890', 'Rua Irineu', 12313, 'Blabla', 'Guaianazes', 'São Paulo', '08431590', 'SP');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbfuncionario`
--

CREATE TABLE `tbfuncionario` (
  `idFuncionario` int(11) NOT NULL,
  `nomeFuncionario` varchar(255) NOT NULL,
  `senha` varchar(32) NOT NULL,
  `cpfFuncionario` varchar(11) NOT NULL,
  `rgFuncionario` varchar(11) NOT NULL,
  `contaBancoFuncionario` varchar(8) NOT NULL,
  `agenciaFuncionario` varchar(6) NOT NULL,
  `nomeBancoFuncionario` varchar(20) NOT NULL,
  `logradouroFuncionario` varchar(255) NOT NULL DEFAULT '',
  `numFuncionario` int(11) NOT NULL DEFAULT 0,
  `complFuncionario` varchar(32) NOT NULL DEFAULT '',
  `bairroFuncionario` varchar(64) NOT NULL DEFAULT '',
  `cidadeFuncionario` varchar(128) NOT NULL DEFAULT '',
  `cepFuncionario` varchar(8) NOT NULL DEFAULT '',
  `ufFuncionario` varchar(2) NOT NULL DEFAULT ''
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbfuncionario`
--

INSERT INTO `tbfuncionario` (`idFuncionario`, `nomeFuncionario`, `senha`, `cpfFuncionario`, `rgFuncionario`, `contaBancoFuncionario`, `agenciaFuncionario`, `nomeBancoFuncionario`, `logradouroFuncionario`, `numFuncionario`, `complFuncionario`, `bairroFuncionario`, `cidadeFuncionario`, `cepFuncionario`, `ufFuncionario`) VALUES
(1, 'nome', 'e10adc3949ba59abbe56e057f20f883e', 'cpf', 'rg', 'conta', 'agenci', 'nomebanco', 'logradouro', 10, 'compl', 'bairro', 'cidade', 'cep', 'uf'),
(3, 'Nome opleto', 'e10adc3949ba59abbe56e057f20f883e', '12345623', '123456789', '12345', '123456', 'Banco do Barril', 'Rua Nomeada', 140, 'Bacate', 'Guaianazes', 'São Paulo', '01234567', 'SP'),
(4, 'Irineu Funcionário', 'c6883b2cf5d5dfa84d3be27da45f41f3', '89189189189', '15618989189', '89189189', '891891', 'Banco do Barril', '', 0, '', '', '', '', '');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbprodutos`
--

CREATE TABLE `tbprodutos` (
  `idProdutos` int(11) NOT NULL,
  `nomeProdutos` varchar(255) NOT NULL,
  `descricaoProdutos` varchar(100) NOT NULL,
  `valorProduto` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbprodutos`
--

INSERT INTO `tbprodutos` (`idProdutos`, `nomeProdutos`, `descricaoProdutos`, `valorProduto`) VALUES
(1, 'Chocolate sem Cacau', 'É muito bom, não tem Cacau nem açucar', '300.00');

-- --------------------------------------------------------

--
-- Estrutura da tabela `tbvenda`
--

CREATE TABLE `tbvenda` (
  `codigoVenda` int(11) NOT NULL,
  `clienteVenda` int(11) NOT NULL,
  `produtoVenda` int(11) NOT NULL,
  `quantidadeVenda` int(11) NOT NULL,
  `valorTotalVenda` decimal(10,2) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Extraindo dados da tabela `tbvenda`
--

INSERT INTO `tbvenda` (`codigoVenda`, `clienteVenda`, `produtoVenda`, `quantidadeVenda`, `valorTotalVenda`) VALUES
(1, 74, 1, 10, '3000.00'),
(2, 74, 1, 1, '300.00');

--
-- Índices para tabelas despejadas
--

--
-- Índices para tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  ADD PRIMARY KEY (`idCliente`);

--
-- Índices para tabela `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  ADD PRIMARY KEY (`idFuncionario`);

--
-- Índices para tabela `tbprodutos`
--
ALTER TABLE `tbprodutos`
  ADD PRIMARY KEY (`idProdutos`);

--
-- Índices para tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  ADD PRIMARY KEY (`codigoVenda`);

--
-- AUTO_INCREMENT de tabelas despejadas
--

--
-- AUTO_INCREMENT de tabela `tbcliente`
--
ALTER TABLE `tbcliente`
  MODIFY `idCliente` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=75;

--
-- AUTO_INCREMENT de tabela `tbfuncionario`
--
ALTER TABLE `tbfuncionario`
  MODIFY `idFuncionario` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT de tabela `tbprodutos`
--
ALTER TABLE `tbprodutos`
  MODIFY `idProdutos` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de tabela `tbvenda`
--
ALTER TABLE `tbvenda`
  MODIFY `codigoVenda` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
