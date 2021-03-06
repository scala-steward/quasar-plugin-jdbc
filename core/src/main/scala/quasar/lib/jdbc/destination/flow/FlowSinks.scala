/*
 * Copyright 2020 Precog Data
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package quasar.lib.jdbc.destination.flow

import cats.Applicative
import cats.effect._

import doobie._

trait FlowSinks[F[_], T, C] extends DeferredFlowSinks[F, T, C] {
  val flowTransactor: Transactor[F]
  def transactorResource(implicit F: Applicative[F]): Resource[F, Transactor[F]] =
    Resource.pure[F, Transactor[F]](flowTransactor)
}

